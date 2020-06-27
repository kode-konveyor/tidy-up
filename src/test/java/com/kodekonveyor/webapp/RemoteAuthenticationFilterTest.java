package com.kodekonveyor.webapp;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.kodekonveyor.annotations.TestedBehaviour;
import com.kodekonveyor.annotations.TestedService;
import com.kodekonveyor.authentication.UserEntityTestData;
import com.kodekonveyor.logging.LoggingMarkers;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@RunWith(MockitoJUnitRunner.class)
@TestedBehaviour("Puts the remote user into the Authentication object")
@TestedService("RemoteAuthenticationFilter")
public class RemoteAuthenticationFilterTest
    extends RemoteAuthenticationFilterTestBase {

  @DisplayName("if authenticated, does not set authenticated user")
  @Test
  public void test() throws IOException, ServletException {
    AuthenticationStubs.authenticated();
    remoteAuthenticationFilter
        .doFilter(
            HttpServletRequestTestData.get(), servletResponse, filterChain
        );
    verify(AuthenticationStubs.securityContext, never())
        .setAuthentication(newAuthentication.capture());
  }

  @DisplayName("if authenticated, calls the filter chain")
  @Test
  public void test01() throws IOException, ServletException {
    AuthenticationStubs.authenticated();
    final HttpServletRequest req = HttpServletRequestTestData.get();
    remoteAuthenticationFilter
        .doFilter(
            req, servletResponse, filterChain
        );
    verify(filterChain)
        .doFilter(req, servletResponse);
  }

  @DisplayName("if the filter authenticates someone, logs the authentication")
  @Test
  public void test02() throws IOException, ServletException {
    AuthenticationStubs.nullAuthentication();
    remoteAuthenticationFilter
        .doFilter(
            HttpServletRequestTestData.get(), servletResponse, filterChain
        );
    verify(loggerService).info(
        Mockito.eq(LoggingMarkers.AUTHENTICATION), stringCaptor.capture()
    );
    WebappTestHelper.assertContains(
        HttpServletRequestTestData.AUTHENTICATED, stringCaptor.getValue()
    );
  }

  @DisplayName(
    "if Authentication is null, sets the remote user as authenticated"
  )
  @Test
  public void test1() throws IOException, ServletException {
    AuthenticationStubs.nullAuthentication();
    remoteAuthenticationFilter
        .doFilter(
            HttpServletRequestTestData.get(), servletResponse, filterChain
        );
    assertRemoteUserIsCorrectlySet();
  }

  @DisplayName(
    "if Authentication is anonymous, sets the remote user as authenticated"
  )
  @Test
  public void test2() throws IOException, ServletException {
    AuthenticationStubs.anonymous();
    remoteAuthenticationFilter
        .doFilter(
            HttpServletRequestTestData.get(), servletResponse, filterChain
        );
    assertRemoteUserIsCorrectlySet();
  }

  @DisplayName(
    "if Authentication is null and the remote user exists, sets the remote user as authenticated"
  )
  @Test
  public void test3() throws IOException, ServletException {
    AuthenticationStubs.nullAuthentication();
    remoteAuthenticationFilter
        .doFilter(
            HttpServletRequestTestData.get(), servletResponse, filterChain
        );
    assertRemoteUserIsCorrectlySet();
  }

  private void assertRemoteUserIsCorrectlySet() {
    verify(AuthenticationStubs.securityContext)
        .setAuthentication(newAuthentication.capture());
    assertEquals(
        UserEntityTestData.AUTH0ID,
        newAuthentication.getValue().getCredentials()
    );
  }

  @DisplayName(
    "if Authentication is null and the remote user does not exists, does not set an authenticated user"
  )
  @Test
  public void test4() throws IOException, ServletException {
    AuthenticationStubs.nullAuthentication();
    remoteAuthenticationFilter.doFilter(
        HttpServletRequestTestData.getRemoteUserUnknown(), servletResponse,
        filterChain
    );
    verify(AuthenticationStubs.securityContext, never())
        .setAuthentication(newAuthentication.capture());
  }

}

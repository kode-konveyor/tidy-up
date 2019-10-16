<?xml version="1.0" encoding="ISO-8859-1"?>
<!DOCTYPE xml>
<xsl:stylesheet version="2.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:zenta="http://magwas.rulez.org/zenta"
	xmlns:zentatools="java:org.rulez.magwas.zentatools.XPathFunctions"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:output method="xml" version="1.0" encoding="utf-8"
		indent="yes" omit-xml-declaration="yes" />

	<xsl:include href="xslt/functions.xslt" />

	<xsl:param name="modelbasename" />
	<xsl:param name="reponame" />
	<xsl:param name="github_org" />

    <xsl:variable name="zenta" select="document(concat($modelbasename,'.zenta'))"/>
    <xsl:variable name="rich" select="/"/>

	<xsl:template match="/">
		<xsl:variable name="testcases">
			<tasks>
				<xsl:call-template name="testcases" />
			</tasks>
		</xsl:variable>
		<xsl:result-document
			href="shippable/{$modelbasename}-testcases.txt">
			<xsl:copy-of
				select="zenta:writeTestcasesAsText($testcases)" />
		</xsl:result-document>
		<xsl:result-document
			href="shippable/{$modelbasename}-testcases.xml">
			<xsl:copy-of select="$testcases" />
		</xsl:result-document>
	</xsl:template>


    <xsl:function name="zenta:drawpic">
        <xsl:param name="picid"/>
            <xsl:variable name="picname" select="$zenta//element[@id=$picid]/@name"/>
            <xsl:variable name="piclink" select="concat(
                'https://repository.kodekonveyor.com/',
               $reponame,
               '/',
               $github_org,
               '/develop/pics/',
               $picid,
               '.png')"/>
[![<xsl:value-of select="$picname"/>](<xsl:value-of select="$piclink"/>)](<xsl:value-of select="$piclink"/>)
    </xsl:function>

	<xsl:function name="zenta:writeTestcasesAsText">
		<xsl:param name="testcases" />
		<xsl:for-each select="$testcases//task">
----------------------------------------------------------------------------
Behaviour: <xsl:value-of select="concat(@service, '/', @behaviour)" />

    @TestedBehaviour("<xsl:value-of select="@behaviour" />")
    @TestedService("<xsl:value-of select="@service" />")

You should modify <xsl:value-of select="concat(@package, '.', @service)" />.

            <xsl:copy-of select="$zenta//element[@id=current()/behaviour/element/@id]/documentation/(*|text())"/>

Relevant views:
            <xsl:variable name="behaviourpics" select="$zenta//element[.//child[@zentaElement=current()/behaviour/element/@id]]/@id"/>
            <xsl:variable name="servicepics" select="$zenta//element[.//child[@zentaElement=current()/behaviour/element/@id]]/@id"/>
            <xsl:for-each select="distinct-values($behaviourpics intersect $servicepics)">
                <xsl:copy-of select="zenta:drawpic(.)"/>
            </xsl:for-each>

More about the service:
            <xsl:for-each select="distinct-values($servicepics except $behaviourpics)">
                <xsl:copy-of select="zenta:drawpic(.)"/>
            </xsl:for-each>
More about the behaviour:
            <xsl:for-each select="distinct-values($behaviourpics except $servicepics)">
                <xsl:copy-of select="zenta:drawpic(.)"/>
            </xsl:for-each>
		</xsl:for-each>

If you have questions, see the [FAQ](https://kodekonveyor.com/coder-faq/), ask on the [Telegram channel](https://t.me/joinchat/D1deE0loEBoFGvyDssWRuw) or ask your mentor.

	</xsl:function>

    <xsl:function name="zenta:fullpackageP">
        <xsl:param name="package"/>
        <xsl:if test="$package">
            <xsl:variable name="parent" select="zenta:fullpackageP(zenta:neighbours($rich,$package,'contains,2')[@xsi:type='Package'])"/>
            <xsl:choose>
                <xsl:when test="$parent">
                    <xsl:value-of select="concat($parent, '.', $package/@name)"/>
                </xsl:when>
                <xsl:otherwise>
                    <xsl:value-of select="$package/@name"/>
                </xsl:otherwise>
            </xsl:choose>
        </xsl:if>
    </xsl:function>

    <xsl:function name="zenta:fullpackage">
        <xsl:param name="service"/>
        <xsl:copy-of select="zenta:fullpackageP(zenta:neighbours($rich,$service,'contains,2')[@xsi:type='Package'])"/>
    </xsl:function>

	<xsl:template name="testcases">
		<xsl:variable name="root" select="/" />
		<xsl:for-each
			select="//element[@template='false' and (@xsi:type='Behaviour' or @xsi:type='Process Step')]">
            <xsl:variable name="behaviour" select="."/>
            <xsl:for-each select="zenta:neighbours(/,.,'is implemented by/implements,1')">
                <task>
                    <xsl:attribute name="service" select="@name"/>
                    <xsl:attribute name="behaviour" select="$behaviour/@name"/>
                    <xsl:attribute name="package" select="zenta:fullpackage(.)"/>
                    <service><xsl:copy-of select="."/></service>
                    <behaviour><xsl:copy-of select="$behaviour"/></behaviour>
                </task>
            </xsl:for-each>
		</xsl:for-each>
	</xsl:template>

</xsl:stylesheet>


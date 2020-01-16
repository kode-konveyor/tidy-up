
package com.kodekonveyor.work_request.offer;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class OfferListDTO {

  private List<OfferDTO> offers = new ArrayList<>();
}

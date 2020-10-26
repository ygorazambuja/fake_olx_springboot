package com.ufms.olx.domain.dto.PedidoDTO;

import com.ufms.olx.domain.enums.StatusPedido;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CriaPedidoDTO {
  @NotEmpty
  private Long idPessoa;
  @NotEmpty
  private StatusPedido statusPedido;
  @NotEmpty
  private LocalDate dataCompra;
  @NotEmpty
  private LocalDate dataEntrega;
}

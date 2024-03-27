package br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.entity.EnderecoEntity;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.utils.EnderecoHelper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class EnderecoEntityRepositoryTest {
   @Mock
   private EnderecoEntityRepository endRep;

   AutoCloseable openMocks;

   @BeforeEach
   void setup() {
      openMocks = MockitoAnnotations.openMocks(this);
   }

   @AfterEach
   void tearDown() throws Exception {
      openMocks.close();
   }

   @Nested
   class SalvarEnderecos {
      @Test
      void devePermitirSalvaEnderecoUsuario() {
         var endereco = EnderecoHelper.gerarEnderecoUsuario();

         when(endRep.save(any(EnderecoEntity.class))).thenAnswer(i -> i.getArgument(0));
         var enderecoSalvo = endRep.save(endereco);

         assertThat(enderecoSalvo).isNotNull().isEqualTo(endereco);

         verify(endRep, times(1)).save(any(EnderecoEntity.class));
      }

      @Test
      void devePermitirSalvaEnderecoRestaurante() {
         var endereco = EnderecoHelper.gerarEnderecoRestaurante();

         when(endRep.save(any(EnderecoEntity.class))).thenAnswer(i -> i.getArgument(0));
         var enderecoSalvo = endRep.save(endereco);

         assertThat(enderecoSalvo).isNotNull().isEqualTo(endereco);

         verify(endRep, times(1)).save(any(EnderecoEntity.class));
      }
   }

   @Nested
   class BuscarEnderecos {
      @Test
      void devePermitirBuscarEnderecoUsuario(){
         var endereco = EnderecoHelper.gerarEnderecoUsuario();
         var id = endereco.getId();
         endereco.setId(id);

         when(endRep.findById(id)).thenReturn(Optional.of(endereco));

         var enderecoRecebidoOpt = endRep.findById(id);

         assertThat(enderecoRecebidoOpt).isPresent().containsSame(endereco);
         enderecoRecebidoOpt.ifPresent(enderecoRecebido -> {
            assertThat(enderecoRecebido.getId()).isEqualTo(endereco.getId());
            assertThat(enderecoRecebido.getCep()).isEqualTo(endereco.getCep());
            assertThat(enderecoRecebido.getLogradouro()).isEqualTo(endereco.getLogradouro());
            assertThat(enderecoRecebido.getNumero()).isEqualTo(endereco.getNumero());
            assertThat(enderecoRecebido.getComplemento()).isEqualTo(endereco.getComplemento());
         });

         verify(endRep, times(1)).findById(id);
      }

      @Test
      void devePermitirBuscarEnderecoRestaurante(){
         var endereco = EnderecoHelper.gerarEnderecoRestaurante();
         var id = endereco.getId();
         endereco.setId(id);

         when(endRep.findById(id)).thenReturn(Optional.of(endereco));

         var enderecoRecebidoOpt = endRep.findById(id);

         assertThat(enderecoRecebidoOpt).isPresent().containsSame(endereco);
         enderecoRecebidoOpt.ifPresent(enderecoRecebido -> {
            assertThat(enderecoRecebido.getId()).isEqualTo(endereco.getId());
            assertThat(enderecoRecebido.getCep()).isEqualTo(endereco.getCep());
            assertThat(enderecoRecebido.getLogradouro()).isEqualTo(endereco.getLogradouro());
            assertThat(enderecoRecebido.getNumero()).isEqualTo(endereco.getNumero());
            assertThat(enderecoRecebido.getComplemento()).isEqualTo(endereco.getComplemento());
         });

         verify(endRep, times(1)).findById(id);
      }

   }

   @Nested
   class RemoverEnderecos {
      @Test
      void devePermitirRemoverEnderecoUsuario(){
         var endereco = EnderecoHelper.gerarEnderecoUsuario();
         var id = endereco.getId();

         doNothing().when(endRep).deleteById(id);
         endRep.deleteById(id);

         verify(endRep, times(1)).deleteById(id);

      }

      @Test
      void devePermitirRemoverEnderecoRestaurante(){
         var endereco = EnderecoHelper.gerarEnderecoRestaurante();
         var id = endereco.getId();

         doNothing().when(endRep).deleteById(id);
         endRep.deleteById(id);

         verify(endRep, times(1)).deleteById(id);
      }

   }


}

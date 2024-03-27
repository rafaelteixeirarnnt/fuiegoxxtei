package br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.entity.EnderecoEntity;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.utils.EnderecoHelper;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureTestDatabase
@Transactional
class EnderecoEntityRepositoryIT {

   @Autowired
   private EnderecoEntityRepository endRep;

   @Nested
   class RegistrarEndereco{
      @Test
      void devePermitirRegistrarEnderecoUsuario(){
         var endereco = EnderecoHelper.gerarEnderecoUsuario();

         var id = ("1234test");
         var enderecoRecebido = endRep.save(endereco);

         assertThat(enderecoRecebido).isInstanceOf(EnderecoEntity.class).isNotNull();
         assertThat(enderecoRecebido.getId()).isEqualTo(id);
         assertThat(enderecoRecebido.getCep()).isEqualTo(endereco.getCep());
         assertThat(enderecoRecebido.getLogradouro()).isEqualTo(endereco.getLogradouro());
         assertThat(enderecoRecebido.getNumero()).isEqualTo(endereco.getNumero());
         assertThat(enderecoRecebido.getComplemento()).isEqualTo(endereco.getComplemento());

      }

      @Test
      void devePermitirRegistrarEnderecoRestaurante(){
         var endereco = EnderecoHelper.gerarEnderecoRestaurante();

         var id = ("1234test");
         var enderecoRecebido = endRep.save(endereco);

         assertThat(enderecoRecebido).isInstanceOf(EnderecoEntity.class).isNotNull();
         assertThat(enderecoRecebido.getId()).isEqualTo(id);
         assertThat(enderecoRecebido.getCep()).isEqualTo(endereco.getCep());
         assertThat(enderecoRecebido.getLogradouro()).isEqualTo(endereco.getLogradouro());
         assertThat(enderecoRecebido.getNumero()).isEqualTo(endereco.getNumero());
         assertThat(enderecoRecebido.getComplemento()).isEqualTo(endereco.getComplemento());

      }
   }

   @Nested
   class BuscarEndereco{
      @Test
      void devePermitirBuscarEnderecoID(){
         var id = "12345test";
         var enderecoRecebidoOpt = endRep.findById(id);

         assertThat(enderecoRecebidoOpt).isPresent();

         enderecoRecebidoOpt.ifPresent(enderecoRecebido -> {
            assertThat(enderecoRecebido.getId()).isEqualTo(id);
         });
      }
      @Test
      void devePermitirBuscarEnderecos(){
         var enderecosObitidos = endRep.findAll();

         assertThat(enderecosObitidos).hasSizeGreaterThan(0);
      }
   }

   @Nested
   class RemoverEndereco{
      @Test
      void devePermitirRemoverEndereco(){
         var id = "1234test";

         endRep.deleteById(id);
         var enderecoRecebidoOpt = endRep.findById(id);

         assertThat(enderecoRecebidoOpt).isEmpty();
      }

   }
}

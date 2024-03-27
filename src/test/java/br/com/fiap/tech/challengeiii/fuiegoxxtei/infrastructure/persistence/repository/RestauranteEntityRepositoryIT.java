package br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.entity.RestauranteEntity;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.utils.RestauranteHelper;
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
class RestauranteEntityRepositoryIT {

   @Autowired
   private RestauranteEntityRepository restRep;

   @Nested
   class RegistrarRestaurantes{
      @Test
      void devePermirtirRegistrarRestaurante(){
         var restaurante = RestauranteHelper.gerarRestaurante();
         var id = "123teste";
         restaurante.setId(id);

         var restauranteRecebido = restRep.insert(restaurante);

         assertThat(restauranteRecebido).isInstanceOf(RestauranteEntity.class).isNotNull();
         assertThat(restauranteRecebido.getId()).isEqualTo(restaurante.getId());
         assertThat(restauranteRecebido.getNomeEstabelecimento()).isEqualTo(restaurante.getNomeEstabelecimento());
         assertThat(restauranteRecebido.getCnpj()).isEqualTo(restaurante.getCnpj());
         assertThat(restauranteRecebido.getTipoCozinha()).isEqualTo(restaurante.getTipoCozinha());
         assertThat(restauranteRecebido.getHrInicioAtendimento()).isEqualTo(restaurante.getHrInicioAtendimento());
         assertThat(restauranteRecebido.getHrFimAtendimento()).isEqualTo(restaurante.getHrFimAtendimento());
         assertThat(restauranteRecebido.getCapacidade()).isEqualTo(restaurante.getCapacidade());
         assertThat(restauranteRecebido.getEmail()).isEqualTo(restaurante.getEmail());
         assertThat(restauranteRecebido.getTelefone()).isEqualTo(restaurante.getTelefone());
         assertThat(restauranteRecebido.getUsuario()).isEqualTo(restaurante.getUsuario());
         assertThat(restauranteRecebido.getEndereco()).isEqualTo(restaurante.getEndereco());

      }
   }

   @Nested
   class BuscarRestaurantes{
      @Test
      void devePermitirBuscarRestauranteID(){
         var id = "123teste";

         var restauranteRecebidoOpt = restRep.findById(id);

         assertThat(restauranteRecebidoOpt).isPresent();
         restauranteRecebidoOpt.ifPresent(restauranteRecebido -> {
            assertThat(restauranteRecebido.getId()).isEqualTo(id);
         });
      }

      @Test
      void devePermitirBuscarRestaurantes(){
         var restaurante = restRep.findAll();

         assertThat(restaurante).hasSizeGreaterThan(0);
      }
   }

   @Nested
   class RemoverRestaurante{
      @Test
      void devePermitirRemoverRestaurante(){
         var id = "123teste";

         restRep.deleteById(id);
         var restauranteRecebidoOpt = restRep.findById(id);

         assertThat(restauranteRecebidoOpt).isEmpty();
      }
   }
}

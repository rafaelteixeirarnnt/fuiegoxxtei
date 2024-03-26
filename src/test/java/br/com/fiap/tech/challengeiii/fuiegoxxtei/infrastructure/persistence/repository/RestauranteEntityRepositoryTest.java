package br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.entity.RestauranteEntity;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.utils.RestauranteHelper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class RestauranteEntityRepositoryTest {

   @Mock
   private RestauranteEntityRepository restRep;

   AutoCloseable openMocks;

   @BeforeEach
   void setup() {
      openMocks = MockitoAnnotations.openMocks(this);
   }

   @AfterEach
   void tearDown() throws Exception {
      openMocks.close();
   }

   @Test
   void devePermitirSalvarRestaurante() {
      var restaurante = RestauranteHelper.gerarRestaurante();

      when(restRep.save(any(RestauranteEntity.class))).thenAnswer((i -> i.getArgument(0)));

      var restSalvo = restRep.save(restaurante);

      assertThat(restSalvo).isNotNull().isEqualTo(restaurante);
      verify(restRep, times(1)).save(any(RestauranteEntity.class));
   }

   @Test
   void devePerimitirBuscarRestaurantePorID() {
      var restaurante = RestauranteHelper.gerarRestaurante();
      var id = restaurante.getId();
      restaurante.setId(id);

      when(restRep.findById(id)).thenReturn(Optional.of(restaurante));

      var restauranteRecebidoOpt = restRep.findById(id);

      assertThat(restauranteRecebidoOpt).isPresent().containsSame(restaurante);
      restauranteRecebidoOpt.ifPresent(restauranteRecebido -> {
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

         verify(restRep, times(1)).findById(id);
      });
   }

   @Test
   void devePermitirListarRestaurantes(){
      var restaurante = RestauranteHelper.gerarRestaurante();
      var rest1 = restaurante;
      var rest2 = restaurante;

      var listaRestaurantes = Arrays.asList(rest1, rest2);
      when(restRep.findAll()).thenReturn(listaRestaurantes);

      var restaurantesRecebidos = restRep.findAll();

      assertThat(restaurantesRecebidos).hasSize(2).containsExactlyInAnyOrder(rest1, rest2);

      verify(restRep, times(1)).findAll();
   }

   @Test
   void devePermitirRemoverRestaurante(){
      var restaurante = RestauranteHelper.gerarRestaurante();
      var id = restaurante.getId();

      doNothing().when(restRep).deleteById(id);

      restRep.deleteById(id);

      verify(restRep, times(1)).deleteById(id);
   }

}

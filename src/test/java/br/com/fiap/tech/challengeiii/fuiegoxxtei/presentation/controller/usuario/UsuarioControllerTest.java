/*
package br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.controller.usuario;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.usuarios.AlteraUsuarioUseCase;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.usuarios.BuscaUsuarioUseCase;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.application.usecases.usuarios.RemoveUsuarioUseCase;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.presentation.dtos.usuario.request.CriacaoUsuarioRequest;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.utils.UsuarioHelper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureTestDatabase
@Transactional
public class UsuarioControllerTest {
   private MockMvc mockMvc;

   @Mock
   private UsuarioController criaUsuarioUseCase;

   @Mock
   private AlteraUsuarioUseCase alteraUsuarioUseCase;

   @Mock
   private BuscaUsuarioUseCase buscaUsuarioUseCase;

   @Mock
   private RemoveUsuarioUseCase removeUsuarioUseCase;

   AutoCloseable mock;

   @BeforeEach
   void setup() {
      mock = MockitoAnnotations.openMocks(this);
      UsuarioController criaUsuario = new UsuarioController(criaUsuarioUseCase);
      */
/*UsuarioController alteraUsuario = new UsuarioController(buscaUsuarioUseCase);
      UsuarioController buscaUsuario = new UsuarioController(alteraUsuarioUseCase);
      UsuarioController removeUsuario = new UsuarioController(removeUsuarioUseCase);*//*

      mockMvc = MockMvcBuilders.standaloneSetup(criaUsuario).build();
      */
/*mockMvc = MockMvcBuilders.standaloneSetup(alteraUsuario).build();
      mockMvc = MockMvcBuilders.standaloneSetup(buscaUsuario).build();
      mockMvc = MockMvcBuilders.standaloneSetup(removeUsuario).build();*//*

   }

   @AfterEach
   void tearDown() throws Exception {
      mock.close();
   }

   @Nested
   class RegistrarUsuario {
      @Test
      void devePermitirRegistrarUsuario() throws Exception {
         var usr = UsuarioHelper.gerarUsuario();

         when(criaUsuarioUseCase.salvar(any(CriacaoUsuarioRequest.class)))
                 .thenAnswer(i -> i.getArgument(0));

         mockMvc.perform(post("/usuarios")
                         .content(asJsonString(usr)))
                 .andExpect(status().isCreated());

         verify(criaUsuarioUseCase, times(1))
                 .salvar(any(CriacaoUsuarioRequest.class));

      }
   }

   @Nested
   class BuscarUsuario {
      */
/*@Test
      void devePermitirBuscarUsuario() {
         var usuario = UsuarioHelper.gerarUsuarioCtrl();

         when(buscaUsuarioUseCase.).thenReturn(usuario);
      }*//*


      @Test
      void listarUsuarios() {
         fail("Teste não implementado");
      }

      @Test
      void deveGerarExcecao_QuandoBuscarUsuario_IdInexistente() {
         fail("Teste não implementado");
      }
   }

   @Nested
   class AlterarUsuario {
      @Test
      void devePermitirAlterarUsuario() {
         fail("Teste não implementado");
      }

      @Test
      void deveGerarExcecao_QuandoAlterarUsuario_IdNaoExiste() {
         fail("Teste não implementado");
      }

      @Test
      void deveGerarExcecao_QuandoAlterarUsuario_IdMsgNovaComValorDiferente() {
         fail("Teste não implementado");
      }

   }

   @Nested
   class RemoverUsuario {
      @Test
      void devePermitirRemoverUsuario() {
         fail("Teste não implementado");
      }

      @Test
      void deveGerarExcecao_QuandoRemoverUsuario_IdNaoExiste() {
         fail("Teste não implementado");
      }
   }

   public static String asJsonString(final Object obj) throws JsonProcessingException {
      return new ObjectMapper().writeValueAsString(obj);
   }
}
*/

package br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.entity.UsuarioEntity;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.utils.UsuarioHelper;
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

class UsuarioEntityRepositoryTest {

   @Mock
   private UsuarioEntityRepository usrRep;

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
   void devePermitirSalvarUsuario(){
      var usuario = UsuarioHelper.gerarUsuario();

      when(usrRep.save(any(UsuarioEntity.class)))
              .thenAnswer(i -> i.getArgument(0));

      var usrSalvo = usrRep.save(usuario);

      assertThat(usrSalvo)
              .isNotNull()
              .isEqualTo(usuario);

      verify(usrRep, times(1))
              .save(any(UsuarioEntity.class));
   }

   @Test
   void devePermitirBuscarUsuarioPorID(){
      var usuario = UsuarioHelper.gerarUsuario();
      var id = usuario.getId();
      usuario.setId(id);

      when(usrRep.findById(id)).thenReturn(Optional.of(usuario));

      var usrRecebidoOpt = usrRep.findById(id);

      assertThat(usrRecebidoOpt).isPresent().containsSame(usuario);
      usrRecebidoOpt.ifPresent(usrRecebido -> {
         assertThat(usrRecebido.getId()).isEqualTo(usuario.getId());
         assertThat(usrRecebido.getCpf()).isEqualTo(usuario.getCpf());
         assertThat(usrRecebido.getNome()).isEqualTo(usuario.getNome());
         assertThat(usrRecebido.getDtNascimento()).isEqualTo(usuario.getDtNascimento());
         assertThat(usrRecebido.getTelefone()).isEqualTo(usuario.getTelefone());
         assertThat(usrRecebido.getResponsavelRestaurante()).isEqualTo(usuario.getResponsavelRestaurante());
         assertThat(usrRecebido.getEmail()).isEqualTo(usuario.getEmail());
         assertThat(usrRecebido.getSituacao()).isEqualTo(usuario.getSituacao());
         assertThat(usrRecebido.getEndereco()).isEqualTo(usuario.getEndereco());

      });

      verify(usrRep, times(1)).findById(id);

   }

   @Test
   void devePermitirListarUsuarios(){
      var usuario = UsuarioHelper.gerarUsuario();
      var usr1 = usuario;
      var usr2 = usuario;

      var listaUsuarios = Arrays.asList(usr1, usr2);
      when(usrRep.findAll()).thenReturn(listaUsuarios);

      var usuariosRecebidos = usrRep.findAll();

      assertThat(usuariosRecebidos).hasSize(2).containsExactlyInAnyOrder(usr1, usr2);
      verify(usrRep, times(1)).findAll();
   }

   @Test
   void devePermitirRemoverUsuario(){
      var usuario = UsuarioHelper.gerarUsuario();
      var id = usuario.getId();

      doNothing().when(usrRep).deleteById(id);
      usrRep.deleteById(id);

      verify(usrRep, times(1)).deleteById(id);
   }
}

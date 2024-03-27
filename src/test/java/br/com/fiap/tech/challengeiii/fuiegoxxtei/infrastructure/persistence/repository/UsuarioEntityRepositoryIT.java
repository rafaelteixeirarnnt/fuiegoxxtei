package br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.repository;

import br.com.fiap.tech.challengeiii.fuiegoxxtei.infrastructure.persistence.entity.UsuarioEntity;
import br.com.fiap.tech.challengeiii.fuiegoxxtei.utils.UsuarioHelper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureTestDatabase
@Transactional
class UsuarioEntityRepositoryIT {

   @Autowired
   private UsuarioEntityRepository usrRep;

   @Test
   void devePermitirCriarDocumento() {
      long totalRegistros = usrRep.count();

      assertThat(totalRegistros).isPositive();
   }

   @Nested
   class RegistrarUsuario{
      @Test
      void devePermitirRegistrarUsuario(){

         var usuario = UsuarioHelper.gerarUsuario();

         var id = "id_123456";
         usuario.setId(id);

         var usuarioRecebido = usrRep.insert(usuario);
         
         assertThat(usuarioRecebido).isInstanceOf(UsuarioEntity.class).isNotNull();
         assertThat(usuarioRecebido.getId()).isEqualTo(usuario.getId());
         assertThat(usuarioRecebido.getCpf()).isEqualTo(usuario.getCpf());
         assertThat(usuarioRecebido.getNome()).isEqualTo(usuario.getNome());
         assertThat(usuarioRecebido.getDtNascimento()).isEqualTo(usuario.getDtNascimento());
         assertThat(usuarioRecebido.getTelefone()).isEqualTo(usuario.getTelefone());
         assertThat(usuarioRecebido.getResponsavelRestaurante()).isEqualTo(usuario.getResponsavelRestaurante());
         assertThat(usuarioRecebido.getEmail()).isEqualTo(usuario.getEmail());
         assertThat(usuarioRecebido.getSituacao()).isEqualTo(usuario.getSituacao());
         assertThat(usuarioRecebido.getEndereco()).isEqualTo(usuario.getEndereco());
         
      }
   }

   @Nested
   class BuscarUsuario{
      @Test
      void devePermitirBuscarUsuarioPorID(){
         var id = "123teste";

         var usrRecebidoOpt = usrRep.findById(id);

         assertThat(usrRecebidoOpt).isPresent();
         usrRecebidoOpt.ifPresent(usrRecebido ->{
            assertThat(usrRecebido.getId()).isEqualTo(id);
         });
      }

      @Test
      void devePermitirBuscarUsuarios(){
         var usuarios = usrRep.findAll();

         assertThat(usuarios).hasSizeGreaterThan(0);
      }
   }

   @Nested
   class RemoverUsuario{
      @Test
      void devePermitirRemoverUsuario(){
         var id = "123teste";

         usrRep.deleteById(id);
         var usrRecebidoOpt = usrRep.findById(id);

         assertThat(usrRecebidoOpt).isEmpty();
      }
   }
}

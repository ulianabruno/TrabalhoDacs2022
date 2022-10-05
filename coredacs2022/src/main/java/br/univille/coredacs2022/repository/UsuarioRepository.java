package br.univille.coredacs2022.repository;

import org.springframework.stereotype.Repository;
import br.univille.coredacs2022.entity.Usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsuario(String usuario);

    Optional<Usuario> findByUsuarioAndSenha(String usuario, String senha);
}

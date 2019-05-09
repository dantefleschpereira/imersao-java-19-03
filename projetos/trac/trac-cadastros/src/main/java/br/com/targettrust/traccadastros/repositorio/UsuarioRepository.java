package br.com.targettrust.traccadastros.repositorio;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.targettrust.traccadastros.entidades.Funcionario;
import br.com.targettrust.traccadastros.entidades.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	@Query("delete Cliente cliente where cliente.login = :login")
	@Transactional
	@Modifying
	void deleteClienteByLogin(@Param("login")String login);

	@Query("delete Funcionario funcionario where funcionario.login = :login")
	@Transactional
	@Modifying
	void deleteFuncionarioByLogin(@Param("login")String login);
			
	@Query("from Funcionario")
	List<Funcionario> findFuncionarios();
	
	@Query("from Funcionario where id = :id")
	Optional<Funcionario> findFuncionarioById(@Param("id") Long id);


}

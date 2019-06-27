package br.com.viagem.gerenciador.repositorio;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.viagem.gerenciador.entidades.Viagem;

@Repository
public class ViagemRepository extends JpaRepository<Viagem, Long> {

	Viagem findByLocalDeDestino(String localDeDestino);

	
}


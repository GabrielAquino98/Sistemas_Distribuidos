package br.com.viagem.gerenciador.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.viagem.gerenciador.dto.ViagemDto;
import br.com.viagem.gerenciador.entidades.Viagem;
import br.com.viagem.gerenciador.repositorio.ViagemRepository;

@Service
public class ViagemServices {
	@Autowired
	private ViagemRepository viagemRepository;

	public List<Viagem> listar() {
		return viagemRepository.findAll();
	}

	public Viagem salvar(ViagemDto viagemDto) {

		Viagem viagem = new Viagem();
		
		viagem.setId(viagemDto.getId());
		viagem.setDt_saida(viagemDto.getDt_saida());
		viagem.setDt_volta(viagemDto.getDt_volta());
		viagem.setLocalDe(viagemDto.getLocalDe());
		viagem.setLocalPara(viagemDto.getLocalPara());
		
		return viagemRepository.save(viagem);
	}

	public Viagem buscar(Long id) {
		Viagem viagem = viagemRepository.findOne(id);

		if (viagem == null) {
			throw new ViagemServiceException("Não existe esta viagem cadastrada");
		}
		return viagem;
	}

}

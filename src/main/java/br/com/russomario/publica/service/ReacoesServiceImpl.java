package br.com.russomario.publica.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.russomario.publica.dominio.Publicacao;
import br.com.russomario.publica.dominio.Reacoes;
import br.com.russomario.publica.dominio.Usuario;
import br.com.russomario.publica.dominio.DTO.request.ReacoesRequestDTO;
import br.com.russomario.publica.dominio.DTO.resposta.ReacoesRepostaDto;
import br.com.russomario.publica.dominio.contrato.ReacoesService;
import br.com.russomario.publica.repository.ReacoesRepository;

@Service
public class ReacoesServiceImpl implements ReacoesService {

    private final ReacoesRepository reacoesRepository;
    private final UsuarioServiceImpl usuarioService;
    private final PublicacaoServiceImpl publicacaoService;

    public ReacoesServiceImpl(ReacoesRepository reacoesRepository, UsuarioServiceImpl usuarioService,
            PublicacaoServiceImpl publicacaoService) {
        this.reacoesRepository = reacoesRepository;
        this.usuarioService = usuarioService;
        this.publicacaoService = publicacaoService;
    }


    @Override
    public ReacoesRepostaDto salvar(ReacoesRequestDTO dto) {

        Usuario usuario = usuarioService.usuarioEntity(dto.getUsuario_id());
        Publicacao publicacao = publicacaoService.getPublicacao(dto.getPublicacao_id());

        Reacoes reacoes = new Reacoes(publicacao, usuario, dto.getReacoesType());
        var reacoaosalva = reacoesRepository.save(reacoes);

        return new ReacoesRepostaDto(reacoaosalva);
    }

    @Override
    public List<ReacoesRepostaDto> listaTodos() {
         
        var reacoes = reacoesRepository.findAll();

         List<ReacoesRepostaDto> reacoesDTO = reacoes.stream()
                    .map(item -> new ReacoesRepostaDto(item))
                    .collect(Collectors.toList());
        return reacoesDTO;
    }

}

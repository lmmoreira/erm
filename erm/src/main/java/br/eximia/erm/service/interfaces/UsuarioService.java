package br.eximia.erm.service.interfaces;

import br.eximia.erm.model.Usuario;
import br.eximia.springutils.data.DataService;

public interface UsuarioService extends DataService<Usuario, Long> {
	
	Usuario findByUsuario(String usuario);
	
}

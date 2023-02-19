Agenda Eletronica integrada com o banco de dados Mysql. O projeto possuí as seguintes classes:

Classe Contato
- Possui os atributos nome, idade, id, dataCadastro
- O atributo ID deve ser gerado automático 
- O atributo dataCadastro deve ser gerado autómatico
- Metódos GET para todos os atributos
- Metódos SET para todos os atributos

Classe Conexão
- Estabelece a conexão com o Banco de Dados
- Os dados de conexão são configurados através do arquivo conexao.properties

Classe contatoDAO
- Método para inserir um novo contato
- Método para alterar um contatop
- Método para listar todos os contatos cadastrados
- Métodos para remover um contato

Classe Main
- Entrada de informações solicitadas ao usuário
- Menu principal com opções

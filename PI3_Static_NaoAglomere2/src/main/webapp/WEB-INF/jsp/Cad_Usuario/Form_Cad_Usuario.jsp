<%-- 
    Document   : Form_Cad_Usuario
    Created on : 18/10/2020, 18:56:53
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/header.css">
        <link rel="stylesheet" href="css/Estilo.css">
        <link rel="stylesheet" href="css/footer.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.11/jquery.mask.min.js"></script>

        <script type="text/javascript">
            $("#telefone").mask("(00) 00000-0000");
            $("#dataNascimento").mask("0000-00-00");
        </script>

    </head>
    <body class="">
        <header class="header">
            <c:import url="../header.jsp"/>
        </header>        

        <div class="containerw"> 
            <h1>Cadastro de Usuário</h1>
            <form method="post" action="salvar-usuario" class="form-group" novalidate>
                <div>
                    <label>Nome: </label>
                    <input type="text" class="form-control" name="nome" value="${nome}">
                    <c:if test="${nomeErro != null}">
                        <span class="erro"><c:out value="${nomeErro}"/></span> 
                    </c:if>

                </div>
                <div>
                    <label>CPF: </label>
                    <input type="text" class="form-control" name="cpf" value="${cpf}" placeholder="Digite apenas Números">
                    <c:if test="${cpfErro != null}">
                        <span class="erro"><c:out value="${cpfErro}"/></span> 
                    </c:if>
                </div>
                <div>
                    <label>E-mail: </label>
                    <input type="email" class="form-control"  name="email" value="${email}">
                    <c:if test="${emailErro != null}">
                        <span class="erro"><c:out value="${emailErro}"/></span> 
                    </c:if>

                </div>
                <div>
                    <label>Data de Nascimento:</label>
                    <input id="dataNascimento" type="date" class="form-control" name="dataNascimento"  placeholder="XXXX-XX-XX" value="${dataNascimento}">
                    <c:if test="${dtNascimentoErro != null}">
                        <span class="erro"><c:out value="${dtNascimentoErro}"/></span> 
                    </c:if>
                </div>
                <div>
                    <label>Telefone:</label>
                    <input type="text" class="form-control" id="telefone" name="telefone" value="${telefone}"
                           >
                    <c:if test="${telefoneErro != null}">
                        <span class="erro"><c:out value="${telefoneErro}"/></span> 
                    </c:if>
                </div>
                <div>
                    <label>Senha:</label>
                    <input type="password" class="form-control" name="senha" value="${senha}">
                    <c:if test="${senhaErro != null}">
                        <span class="erro"><c:out value="${senhaErro}"/></span>
                    </c:if>

                </div>
                <div>
                    <label>Confirmar Senha:</label>
                    <input type="password" class="form-control" name="confirmarSenha" value="${confirmarSenha}">
                    <c:if test="${ConfirmSenhaErro != null}">
                        <span class="erro"><c:out value="${ConfirmSenhaErro}"/></span>
                    </c:if>
                    <c:if test="${add != null}">
                        <span><c:out value="${add}"/></span>
                    </c:if>

                </div>
                <div>
                    <input name="check" type="checkbox"> Li e aceito a <button type="button" class="btn-link" data-toggle="modal" data-target="#politica">Política de privacidade</button> e os <button type="button" class="btn-link" data-toggle="modal" data-target="#termo">termos de uso</button>
                    <c:if test="${checkErro != null}">
                        <span class="erro"><c:out value="${checkErro}"/></span>
                    </c:if>
                </div>

                <!-- The Modal -->
                <div class="modal" id="politica">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <!-- Modal Header -->
                            <div class="modal-header">
                                <h4 class="modal-title">Política de privacidade</h4>
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                            </div>
                            <!-- Modal body -->
                            <div class="modal-body">
                                A sua privacidade é importante para nós. É política do Não Aglomere respeitar a sua privacidade em relação a qualquer informação sua que possamos coletar no nosso site. Não compartilhamos informações de identificação pessoal publicamente ou com terceiros, exceto quando exigido por lei.
                                <br>O nosso site pode ter links para sites externos que não são operados por nós. Esteja ciente de que não temos controle sobre o conteúdo e práticas desses sites e não podemos aceitar responsabilidade por suas respectivas políticas de privacidade.
                                <br>O uso continuado de nosso site será considerado como aceitação de nossas práticas em torno de privacidade e informações pessoais.
                            </div>

                            <!-- Modal footer -->
                            <div class="modal-footer">
                                <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- The Modal -->
                <div class="modal" id="termo">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <!-- Modal Header -->
                            <div class="modal-header">
                                <h4 class="modal-title">Termos de uso</h4>
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                            </div>
                            <!-- Modal body -->
                            <div class="modal-body">
                                Ao utilizar os serviços do Não Aglomere, você concorda em não agir com más intenções ou fazer mal uso da plataforma para quaisquer outros fins que não sejam:
                                <br>1-Realizar cadastro na plataforma.
                                <br>2-Fazer consultas de estabelecimentos com fins de se informar sobre a situação do mesmo.
                                <br>3-Gerar código de ida ao estabelecimento.*
                                <br>4-Realizar agendamento de ida ao estabelecimento.**
                                <br>5-Ser informado sobre novidades em relação ao COVID-19.
                                <br>*Só será possível gerar um único código por pessoa em cada estabelecimento a cada dia, os estabelecimentos poderão oferecer benefícios que julguem condizentes com a geração e apresentação do código no endereço cadastrado no site.
                                <br>**Caso a empresa reporte o não comparecimento ou o usuário não informe a empresa, na primeira vez haverá uma advertência, na próxima ocorrência o cadastro será suspenso.
                                <br>Mais informações em contatonaoaglomere@gmail.com
                            </div>
                            <!-- Modal footer -->
                            <div class="modal-footer">
                                <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                            </div>
                        </div>
                    </div>
                </div>
                <div>
                    <button type="submit" class="btn btn-success botoes"  data-toggle="modal" data-target="#myModal">Efetuar Cadastro</button>
                    <button type="reset" class="btn btn-danger botoes">Cancelar</button>

                </div>
            </form>
        </div>

        <footer class="footer">
            <c:import url="../footer.jsp"/>
        </footer>
    </body>
</html>

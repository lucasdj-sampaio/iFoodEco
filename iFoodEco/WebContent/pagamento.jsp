<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="pt-br"> 	
 	<head>
        <%@ include file="directiva.jsp" %>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    </head>
    <body>

        <header>
            <div class="cabeçalho" >
                <h1 class="seta"><a href="cadastro_proprietario.jsp"><img src="Imagem/seta2.png" alt="Voltar"></a></h1>
                <h1 class="logo" style="display: block; margin-right: auto; margin-left: auto;" ><img src="Imagem/logo_ifood3.png" alt="Logo Ifood"></h1>       
            </div>           
            <div class="faixa"></div>
        </header>
       
        <main class="main_formato">
        	<div class="principal_pagamento">
                <h1 class="titulo-principal">Forma de pagamento</h1>
                <h3 class="subtitulo" >Preencha abaixo as formas de pagamento aceitas em seu negócio.</h3>
			</div>

			<div class="container" style="display: flex;">
                <form action="fourthStep" method="post">
				    <div class="container-1" style="width: 500px">
					    
                        <div>                   		
                            <label>
                                <input type="checkbox" name="pagamento" value="IFOOD_ONLINE" style="margin: 10px 2px;">Ifood Online
                            </label>
                        </div>  
                        <div>           
                            <label>
                                <input type="checkbox" name="pagamento" value="AM"  style="margin: 10px 2px;">AMEX
                            </label>   
                        </div> 
                        <div> 
                            <label>
                                <input type="checkbox" name="pagamento" value="MC" style="margin: 10px 2px;">Mastercard
                            </label>
                        </div>
                        <div>
                            <label>
                                <input type="checkbox" name="pagamento" value="ELO" style="margin: 10px 2px;">Elo
                            </label>
                        </div>
                        <div>
                            <label>
                                <input type="checkbox" name="pagamento" value="DIN" style="margin: 10px 2px;">Dinheiro
                            </label>
                        </div>
                        <div>
                            <label>
                                <input type="checkbox" name="pagamento" value="VIS" style="margin: 10px 2px;">Visa
                            </label>
                        </div>	                    
                        <div>              	
                            <label>
                                <input type="checkbox" name="pagamento" value="PAY" style="margin: 10px 2px;">PayPal
                            </label>
                        </div> 
                        <div>
                            <label>
                                <input type="checkbox" name="pagamento" value="VVREST" style="margin: 10px 2px;">Vale alelo
                            </label>
                        </div> 	                    
                        <div>
                            <label>
                                <input type="checkbox" id="pix1" onClick="habilitacao()" name="pagamento67"style="margin: 10px 2px;">PIX
                            </label>
                        </div>
                       
                        <fieldset id="opcao" onchange="displayPagamento(this.value)"> 
                            <label>Selecione as chaves:</label>
                            <label><input type="radio" name="cnpjPix" value="cnpj_cpf" id="cnpj1" onchange="displayPagamento(this.value)" disabled>CNPJ/CPF</label>
                            <label><input type="radio" name="emailPix" value="email"  id="email1" onchange="displayPagamento(this.value)"disabled>E-mail</label>
                            <label><input type="radio" name="celularPix" value="celular" id="celular1" onchange="displayPagamento(this.value)"disabled>Celular</label>
                            <label><input type="radio" name="aleatoriaPix" value="aleatoria" id="aleatoria1" onchange="displayPagamento(this.value)"disabled>Aleatório</label>                                            
                        </fieldset>
                   
                        <div id="cnpjPagamento" style="display:none;"><br/>
                            <input name="cnpjPixValor" type="text" placeholder="000.000.000-00" />                      
                            <img id="botao_excluir" src="Imagem/excluir.png" onclick="clicar('excluir1')">
                        </div>

                        <div id="emailPagamento" style="display:none;"><br/>
                            <input name="emailPixValor" type="text" placeholder="email@email.com" />
                            <img id="botao_excluir" src="Imagem/excluir.png" onclick="clicar('excluir2')">      
                        </div>

                        <div id="celularPagamento" style="display:none;"><br/>
                            <input name="celularPixValor" type="text" placeholder="(00)00000-0000" />
                            <img id="botao_excluir" src="Imagem/excluir.png" onclick="clicar('excluir3')">   
                        </div> 

                        <div id="aleatoriaPagamento" style="display:none;"><br/>
                            <input name="aleatoriaPixValor" type="text" />
                            <img id="botao_excluir" src="Imagem/excluir.png" onclick="clicar('excluir4')">   
                        </div> 

                        <input type="submit" value="Continuar" class="enviar">                
                    </div>
                </form>
                
                <script>
                    function habilitacao(){
                        if(document.getElementById('pix1').checked == true){
                        document.getElementById('cnpj1').disabled = false;
                        document.getElementById('email1').disabled = false;
                        document.getElementById('celular1').disabled = false;
                        }
                        if(document.getElementById('pix1').checked == false){
                            document.getElementById('cnpj1').disabled = true;
                            document.getElementById('email1').disabled = true;
                            document.getElementById('celular1').disabled = true;
                        }
                    }
                </script>

                <script>
                    function displayPagamento(answer) {
                        if (answer == "selecione") { // hide the div that is not selected
                            document.getElementById('selecionePagamento').style.display = "block";
                        } else if (answer == "cnpj") {
                            document.getElementById('cnpjPagamento').style.display = "block";
                        } else if (answer == "email") {
                            document.getElementById('emailPagamento').style.display = "block";
                        } else if (answer == "celular") {
                            document.getElementById('celularPagamento').style.display = "block";
                        } else if (answer == "aleatoria") {
                            document.getElementById('aleatoriaPagamento').style.display = "block";
                        }
                    }
                </script>

                <script>
                    function clicar(answer) {
                        if (answer == "selecione") { // hide the div that is not selected
                            document.getElementById('selecionePagamento').style.display = "none";
                        } else if (answer == "excluir1") {
                            document.getElementById('cnpjPagamento').style.display = "none";
                            document.getElementById("cnpj1").checked = false;
                        } else if (answer == "excluir2") {
                            document.getElementById('emailPagamento').style.display = "none";
                            document.getElementById("email1").checked = false;
                        } else if (answer == "excluir3") {
                            document.getElementById('celularPagamento').style.display = "none";
                            document.getElementById("celular1").checked = false;
                        }
                        else if (answer == "excluir4"){
                            document.getElementById('aleatoriaPagamento').style.display = "none";
                            document.getElementById("aleatoria1").checked = false; 
                        }
                    }
                </script>
			</div>
	    </main>
    </body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
    <html lang="pt-br">     
    <head>
        <%@ include file="directiva.jsp" %>
    </head>    

    <body>

        <div class="faixa-indice">
           <h1 class="logo" style="margin: 10px 70px; "><img src="Imagem/logo_ifood3.png" alt="Logo Ifood"></h1> 
           <div>
                <div class="indice1" style="display: inline-flex;margin: 10px">
                    <h1 ><img src="Imagem/1.png" width="20px" style="margin: 0 10px;"></h1>             
                    <h3>Inicio</h3> 
                </div>
            </div>

            <div>
                <div class="indice2" style="display: inline-flex; margin: 10px;">
                    <h1><img src="Imagem/2-vermelho.png"width="20px" style="margin: 0 10px;"></h1> 
                    <h3 style="color: #ea1d2c;">Perfil</h3>
                </div>
            </div>
            <div>
                <div class="indice9" style="display: inline-flex;margin: 10px">
                    <h1><img src="Imagem/9.png"width="20px" style="margin: 0 10px;"></h1> 
                    <h3 >Formas de pagamento</h3>
                </div>
            </div>
            <div>
                <div class="indice12" style="display: inline-flex;margin: 10px">
                    <h1><img src="Imagem/12.png"width="15px" style="margin: 0 12px;"></h1> 
                    <h3>Embalagens</h3>
                </div>
            </div>
            <div>
                <div class="indice3" style="display: inline-flex;margin: 10px">
                    <h1><img src="Imagem/3.png"width="20px" style="margin: 0 10px;"></h1> 
                    <h3>Avaliações</h3>
                </div>
            </div>
            <div>
                <div class="indice4" style="display: inline-flex;margin: 10px">
                    <h1><img src="Imagem/4.png"width="15px" style="margin: 0 12px;"></h1> 
                    <h3>Pedidos</h3>
                </div>
            </div>
            <div>
                <div class="indice5" style="display: inline-flex;margin: 10px">
                    <h1><img src="Imagem/5.png"width="10px" style="margin: 0 15px;"></h1> 
                    <h3>Financeiro</h3>
                </div>
            </div>
            <div>
                <div class="indice6" style="display: inline-flex;margin: 10px">
                    <h1><img src="Imagem/6.png"width="15px" style="margin: 0 12px;"></h1> 
                    <h3>Cardápios</h3>
                </div>
            </div>
            <div>
                <div class="indice7" style="display: inline-flex;margin: 10px">
                    <h1><img src="Imagem/7.png"width="20px" style="margin: 0 10px;"></h1> 
                    <h3>Horários</h3>
                </div>
            </div>
            <div>
                <div class="indice8" style="display: inline-flex;margin: 10px">
                    <h1><img src="Imagem/8.png"width="15px" style="margin: 0 12px;"></h1> 
                    <h3>Areas de entrega</h3>
                </div>
            </div>           
            <div>
                <div class="indice10" style="display: inline-flex;margin: 10px">
                    <h1><img src="Imagem/10.png"width="20px" style="margin: 0 10px;"></h1> 
                    <h3>Marketing</h3>
                </div>
            </div>
            <div>
                <div class="indice11" style="display: inline-flex;margin: 10px">
                    <h1><img src="Imagem/11.png"width="20px" style="margin: 0 10px;"></h1> 
                    <h3>Promoções</h3>
                </div>
            </div>           
            <div>
                <div class="indice13" style="display: inline-flex;margin: 10px">
                    <h1><img src="Imagem/13.png"width="20px" style="margin: 0 10px;"></h1> 
                    <h3>Serviços</h3>
                </div>
            </div>
            <div>
                <div class="indice14" style="display: inline-flex;margin: 10px">
                    <h1><img src="Imagem/14.png"width="20px" style="margin: 0 10px;"></h1> 
                    <h3>Desempenho</h3>
                </div>
            </div>
            <div>
                <div class="indice15" style="display: inline-flex;margin: 10px">
                    <h1><img src="Imagem/15.png"width="20px" style="margin: 0 10px;"></h1>            
                    <h3>Chamados e pedidos</h3>           
                </div>
            </div>
        </div>
        <main class="main_formato_recadastro">


            <div>
                <label for="cnpj"style="font-size: 15px; ">CNPJ</label>
            </div>
            <div>
                <input id="cnpj-selecao" type="text" required style="width: 500px; height: 40px; font-size: 17px; margin: 0 0 30px;" /> 
            </div>
            <div>
                <label for="plano"style="font-size: 15px; ">Plano selecionado</label>
            </div>
            <div style="display: inline-flex;">
                <input id="plano-selecao" type="text" required style="width: 500px; height: 40px; font-size: 17px; margin: 0 0 30px;" />
                <h1><img src="Imagem/editar.png"width="20px" style="margin: 10px 10px;"></h1> 
            </div>
            <div>
                <label for="categoria"style="font-size: 15px;">Categora Selecionada</label>
            </div>
            <div>
                <div style="display: inline-flex;">
                    <input id="categoria-selecao" type="text" required style="width: 500px; height: 40px; font-size: 17px; margin: 0 0 30px;" /> 
                    <h1><img src="Imagem/editar.png"width="20px" style="margin: 10px 10px;"></h1> 
                </div>
            </div>
            <div>
                <label for="nome-restaurante"style="font-size: 15px; margin: 20px 0">Nome do restaurante</label>
            </div>
            <div>
                <div style="display: inline-flex;">
                    <input id="nome-restaurante-selecao" type="text" required style="width: 500px; height: 40px; font-size: 17px; margin: 0 0 30px;" />
                    <h1><img src="Imagem/editar.png"width="20px" style="margin: 10px 10px;"></h1> 
                </div>
            </div>
            <div>
                <label for="telefone"style="font-size: 15px; margin: 20px 0">Número de telefone</label>
            </div>
            <div>
                <div style="display: inline-flex;">
                    <input id="telefone-selecao" type="text" required style="width: 500px; height: 40px; font-size: 17px; margin: 0 0 30px;" />
                    <h1><img src="Imagem/editar.png"width="20px" style="margin: 10px 10px;"></h1>  
                </div>
            </div>
            <div>
                <label for="email"style="font-size: 15px; margin: 20px 0">E-mail</label>
            </div>
            <div style="display: inline-flex;">
                <input id="email-selecao" type="text" required style="width: 500px; height: 40px; font-size: 17px; margin: 0 0 30px;" />
                <h1><img src="Imagem/editar.png"width="20px" style="margin: 10px 10px;"></h1>  
            </div>
            <div>
                <label for="endereco-selecao"style="font-size: 15px; margin: 20px 0">Endereço</label>
            </div>
            <div style="display: inline-flex;">
                <input id="endereco-selecao" type="text" required style="width: 500px; height: 40px; font-size: 17px; margin: 0 0 30px;" /> 
                <h1><img src="Imagem/editar.png"width="20px" style="margin: 10px 10px;"></h1> 
            </div>
            <div>
                <label for="logradouro"style="font-size: 15px; margin: 20px 0">Logradouro</label>
            </div>
            <div style="display: inline-flex;">
                <input id="logradouro-selecao" type="text" required style="width: 500px; height: 40px; font-size: 17px; margin: 0 0 30px;" />
                <h1><img src="Imagem/editar.png"width="20px" style="margin: 10px 10px;"></h1>  
            </div>
            <div>
                <label for="cep"style="font-size: 15px; margin: 20px 0">CEP</label>
            </div>
            <div style="display: inline-flex;">
                <input id="cep-selecao" type="text" required style="width: 500px; height: 40px; font-size: 17px; margin: 0 0 30px;" />
                <h1><img src="Imagem/editar.png"width="20px" style="margin: 10px 10px;"></h1>  
            </div>
            <div>
                <label for="nr-logradouro"style="font-size: 15px; margin: 20px 0">Número do logradouro</label>
            </div>
            <div>
                <div style="display: inline-flex;">
                    <input id="nr-logradouro-selecao" type="text" required style="width: 500px; height: 40px; font-size: 17px; margin: 0 0 30px;" /> 
                    <h1><img src="Imagem/editar.png"width="20px" style="margin: 10px 10px;"></h1> 
                </div>
            </div>            
            <label for="complemento"style="font-size: 15px; margin: 20px 0">Complemento</label>
        
            <div>
                <div style="display: inline-flex;">
                    <input id="complemento" type="text" required style="width: 500px; height: 40px; font-size: 17px; margin: 0 0 30px;" /> 
                    <h1><img src="Imagem/editar.png"width="20px" style="margin: 10px 10px;"></h1> 
                </div>
            </div>
        </main>
    </body>
</html>
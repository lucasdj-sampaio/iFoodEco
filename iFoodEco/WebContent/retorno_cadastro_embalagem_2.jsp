<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="pt-br">     
    <head>
        <%@ include file="directiva.jsp" %>
    </head>    

    <body>

        <div class="embalagens_cadastradas" style="margin: 30px 400px;" >
            <h1 class="titulo-principal-recadastro">Embalagens Cadastradas</h1>                        
        </div>  
        
        <div class="faixa-indice">
            <h1 class="logo" style="margin: 10px 70px; " ><img src="Imagem/logo_ifood3.png" alt="Logo Ifood"></h1> 
            <div>
                <div class="indice1" style="display: inline-flex;margin: 10px">
                    <h1 ><img src="Imagem/1.png" width="20px" style="margin: 0 10px;"></h1>             
                    <h3>Inicio</h3> 
                </div>

            </div>
            
            <div>
                <div class="indice2" style="display: inline-flex; margin: 10px;">
                    <h1><img src="Imagem/2.png"width="20px" style="margin: 0 10px;"></h1> 
                    <h3 class="indice2">Perfil</h3>
                </div>
            </div>

            <div>
                <div class="indice9" style="display: inline-flex;margin: 10px">
                    <h1><img src="Imagem/9.png"width="20px" style="margin: 0 10px;"></h1> 
                    <h3 class="indice9">Formas de pagamento</h3>
                </div>
            </div>
            
            <div>
                <div class="indice12" style="display: inline-flex;margin: 10px">
                    <h1><img src="Imagem/12-vermelho.png"width="15px" style="margin: 0 12px;"></h1> 
                    <h3 class="indice12"style="color: #ea1d2c;">Embalagens</h3>
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
                <label>
                    <input type="checkbox" name="pagamento1"style="margin: 10px 2px;">Embalagem de vidro
                </label>  
            </div>
            <div>
                <label>
                    <input type="checkbox" name="pagamento2" style="margin: 10px 2px;">Embalagem de aluminio
                </label> 
            </div>
            <div>
                <label>
                    <input type="checkbox" name="pagamento3"style="margin: 10px 2px;">Embalagem de isopor
                </label> 
            </div>
            <div>                        
                <label>
                    <input type="checkbox" name="pagamento4"style="margin: 10px 2px;">Embalagem de plástico
                </label>
            </div>
            <div>
                <label>
                    <input type="checkbox" name="pagamento4"style="margin: 10px 2px;">Embalagem de papel
                </label>
            </div>
            <div>
                <label>
                    <input type="checkbox" name="pagamento4"style="margin: 10px 2px;">Talher de plástico
                </label>
            </div>
            <div>
                <label>
                    <input type="checkbox" name="pagamento4"style="margin: 10px 2px;">Canudo de plástico
                </label>
            </div>
            <div>
                <label>
                    <input type="checkbox" name="pagamento5"style="margin: 10px 2px;">Outros
                </label>
            </div>
            <div>
                <input type="submit" value="Atualizar" class="enviar">
            </div>
        </main>
    </body>
</html>
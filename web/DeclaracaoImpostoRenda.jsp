<%-- 
    Document   : CadResponsavel
    Created on : Apr 17, 2016, 9:28:59 AM
    Author     : Logan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Sistema de Declaração de Impostos</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap.css">
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="js/bootstrap.min.js"></script>
        <link href="assets/css/custom.css" rel="stylesheet" />
        <style>
            /* Remove the navbar's default margin-bottom and rounded borders */ 
            .navbar {
                margin-bottom: 0;
                border-radius: 0;
            }
        </style>


    </head>
    <body>
        <nav class="navbar navbar-inverse" style="min-height: 135px">
            <div class="container-fluid">

                <div class="container" id="divMenu" style="padding-top: 1cm">
                    <ul class="nav navbar-nav">
                        <p><h2>Sistema de Declaração de Imposto de Renda</h2></p>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="jumbotron">
            <div class="container text-center">
                <p>Declarar Imposto</p>
            </div>
            <div class="container">
                <form action="CadastroReceita" method="post">  
                    <div class="form-group row">
                        <label for="txtNome" class="col-sm-2 form-control-label">Nome</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="txtNome" describedby="basic-addon2" >
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="txtCpf" class="col-sm-2 form-control-label">CPF</label>
                        <div class="col-sm-4">
                            <input type="text" maxlength="11" class="form-control" name="txtCpf">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="txtAnoReferencia" class="col-sm-2 form-control-label">Ano de Referência</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="txtAnoReferencia" >
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="txtValorTotalReceitas" class="col-sm-2 form-control-label">Valor Total Receitas</label>
                        <div class="col-sm-4">
                            <input type="text"  class="form-control" name="txtValorTotalReceitas">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="txtValorTotalDespesas" class="col-sm-2 form-control-label">valor Total Despesas</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="txtValorTotalDespesas">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="txtValorPagoImpostoAno" class="col-sm-2 form-control-label"> Valor Pago Imposto ao Ano</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="txtPagoImpostoAno">
                        </div>
                    </div>
                    <button type="submit" class="btn btn-warning">Enviar Declaração</button>
                </form>
            </div>
        </div>
        <footer class="container-fluid text-center">
            <p>SDI- Sistema de Declaração de Impostos, Copyright © 2016 </p>
        </footer>
    </body>
</html>

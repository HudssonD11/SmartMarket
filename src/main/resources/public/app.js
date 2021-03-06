function mostrarMercados(mercados) {
    let tela = document.getElementById('tela');
    let strHtml = '';

    for (i = 0; i < mercados.length - 1; i++) {
        strHtml += `<div class="col-12 col-sm-12 col-md-6 col-lg-4">
        <div class="mercado noUnderline">
            <a href="mercados/${mercados[i].id}">
                <h1>${mercados[i].nome}</h1>
            </a>
            <hr>
            <a href="mercados/${mercados[i].id}">
            <img src="${mercados[i].imagem}">
            </a>
			<hr>
            <p style="color: grey;">${mercados[i].cidade} - ${mercados[i].estado}<br>${mercados[i].bairro}</p>
        </div>
    </div> `;
    }
    tela.innerHTML = strHtml;
}

function mostrarProdutos(produtos) {
    let tela = document.getElementById('tela');
    let strHtml = '';

    for (i = 0; i < (produtos.length - 1); i++) {
        strHtml +=
            `
            <div class="col-12 col-sm-12 col-md-6 col-lg-4 box-produto noUnderline">
                <div class="produto">
                    <a href="produtos/${produtos[i].id}">
                        <h1>${produtos[i].nome}</h1>
                        <p>${produtos[i].categoria}</p>
                    <img src="${produtos[i].imagem}">
                    </a>
                    <a href="produtos/${produtos[i].id}"><button type="button" class="btn btn-secondary" id="btn_oferta">Ver Ofertas</button></a>
                </div>
            </div>
            `
    }
    tela.innerHTML = strHtml;
}

function mostrarMercado(mercado, produtos) {
    let tela = document.getElementById('tela');
    let supermercado = document.getElementById('mercado');
    let strhtml = `    
    <div class="col-12 col-sm-12 col-md-12 col-lg-6 publicidade_produtos">
                    <img src="${mercado.imagem}" class="logo">
                </div>
                <div class="col-12 col-sm-12 col-md-12 col-lg-6 publicidade_produtos">
                  <h1>${mercado.nome}</h1>
                  <p>Estamos localizados no endereço: Rua ${mercado.rua} - ${mercado.numero}, ${mercado.bairro}, ${mercado.cidade} - ${mercado.estado}</p>
    </div>
    `;
    for (i = 0; i < produtos.length - 1; i++) {
        strhtml += `
        <div class="col-12 col-sm-12 col-md-12 col-lg-4 box-produto">
        <div class="produto noUnderline">
            <a href="/produtos/${produtos[i].id}">
                <h1>${produtos[i].nome}</h1>
            </a>
                <p>${produtos[i].categoria}</p>
            <a href="/produtos/${produtos[i].id}">
            <img src="${produtos[i].imagem}">
            </a>
            <p class="Supermercado">R$${produtos[i].preco}</p>
        </div>
        </div>
        
        `;
    }

    tela.innerHTML = strhtml;
    supermercado.innerHTML = str2html;

}

function mostrarProduto(produto, mercados) {
    let tela = document.getElementById('tela');
    let strhtml = `<div class="col-12 col-sm-12 col-md-12 col-lg-3 comparative">
        <div class="produto">
                <h1>${produto.nome}</h1>
                <p>${produto.marca} - ${produto.unidade} <br> ${produto.descricao}</p>
            <img src="${produto.imagem}">
        </div>
    </div>
    <div class="col-12 col-sm-12 col-md-12 col-lg-7 linha noUnderline">
    `;

    for (i = 0; i < mercados.length - 1; i++) {
        strhtml += `<p class="Supermercado"><a href="../mercados/${mercados[i].id}">${mercados[i].nome}</a></p>
        `;
    }
    strhtml += `</div><div class="col-12 col-sm-12 col-md-12 col-lg-2 linha">`;
    for (i = 0; i < mercados.length - 1; i++) {
        strhtml += `<p class="Supermercado">R$${mercados[i].preco}</p>`;
    }
    strhtml += `</div>`;

    tela.innerHTML = strhtml;
}

function mostrarProdutosMercado(produto) {
    let tela = document.getElementById('tela');
    let descricao = document.getElementById('descricao');
    alert("Em breve logo do mercado")
    let strhtml2 = ''

    strhtml2 += `<div class="col-12 col-sm-12 col-md-12 col-lg-6 publicidade_produtos">
                    <img src="#" class="logo">
                </div>
                <div class="col-12 col-sm-12 col-md-12 col-lg-6 publicidade_produtos">
                  <h1>${mercado[i].nome}</h1>
                  <p>Estamos localizados no endereço: Rua ${mercado[i].rua} - ${mercado[i].numero}, ${mercado[i].bairro}, ${mercado[i].cidade} - ${mercado[i].estado}</p>
                </div>`
    descricao.innerHTML = strhtml2;
    let strhtml = ''

    for (let i = 0; i < produto.length - 1; i++) {
        strhtml += `<div class="col-12 col-sm-12 col-md-12 col-lg-4 box-produto">
        <div class="produto">
                <h1>${produto[i].nome} ${produto[i].unidade}</h1>
            <img src="${produto[i].imagem}">
            <p class="Supermercado">R$${produto[i].preco}</p>
        </div>
    </div>`

    }

    tela.innerHTML = strhtml;
}

function showTelaEditUser() {
    user = getUserLS();
    let tela = document.getElementById('tela4');
    let tela2 = document.getElementById('tela2');
    let strhtml = ''
    let strhtml2 = ''

    strhtml += `
                        <form action="/edit/user" method="post">
                        <input type="text" name="username" id="user1" class="form-control" value="${user.login}" class = "edit" required>
                        <label for="username">Novo nome de Usuário</label><br>
                        <input type="text" name="newusername" id="user" class="form-control" placeholder="Novo nome de usuário" class = "edit" required>
                        <label for="username">Senha</label><br>
                        <input type="password" name="password" id="senha" class="form-control" placeholder="Senha" required>
                        <input type="submit" value="Alterar Usuário" class="btn btn-primary" id="btn-cad"> </form>   
                    </div>`

    strhtml2 += `
                        <h1>Editar Senha</h1>
                        <form action="/edit/senha" method="post">
                        <input type="text" name="username" id="user1" class="form-control" value="${user.login}" class = "edit" required>   
                        <label for="username">Senha antiga</label><br>
                        <input type="password" name="oldpassword" id="senhaAntiga" class="form-control" placeholder="Senha" required>
                        <label for="password">Nova senha</label><br>
                        <input type="password" name="password" id="senhaNova" class="form-control" placeholder="Senha" required>
                        <input type="submit" value="Alterar Senha" class="btn btn-primary" id="btn-cad"> </form>
                     </div>`

    tela4.innerHTML = strhtml;
    tela2.innerHTML = strhtml2;
}

function isAdmin(bool, pagina) {
    let tela = document.getElementById('menu');
    let strmenu = `
	<header class="container header">
    <nav class="navbar navbar-expand-lg navbar-light bg-light menu">

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSite">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSite">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item name">
                    <a class="nav-link" href="REPLACEindex.html">SmartMarket</a>
                </li>
                <li class="nav-item menu_item">
                    <a class="nav-link" >|</a>
                </li>
                <li class="nav-item menu_item">
                    <a class="nav-link" href="REPLACEprodutos" method="get">Produtos</a>
                </li>
                <li class="nav-item menu_item">
                    <a class="nav-link" href="REPLACERefreshPrices.html" method="get">Refresh</a>
                </li>
                <li class="nav-item menu_item">
                    <a class="nav-link">|</a>
                </li>
                <li class="nav-item menu_item">
                    <a class="nav-link" href="REPLACEmercados" method="get">Supermercados</a>
                <li class="nav-item menu_item">
                    <a class="nav-link">|</a>
                </li>
					LUGAR1`;
    let user = getUserLS();

    if (user && user.nome) {
        strmenu = strmenu.replaceAll('LUGAR1', ``);

        if (user.tipo == 'a') {
            strmenu += `
					    <li class="nav-item menu_item">
	                        <a class="nav-link" href="REPLACEmercado">AdcMarket</a>
	                    </li>
					    <li class="nav-item menu_item">
	                        <a class="nav-link">|</a>
	                	</li>
	                    <li class="nav-item menu_item">
	                        <a class="nav-link" href="REPLACEproduto">AdcProduct</a>
	                    </li>
	            	    <li class="nav-item menu_item">
                    		<a class="nav-link">|</a>
            			</li>
						`;
        }
        strmenu += `
                <li class="nav-item menu_item">
                    <a class="nav-link" href="edit" method="get">${user.login}</a>
                </li>
   			    <li class="nav-item menu_item">
                    <a class="nav-link">|</a>
            	</li>
                <li class="nav-item menu_item">
                    <a class="nav-link" onClick="logOut('${pagina}')" href="index.html">LogOut</a>
                </li>
                `;

    } else {

        strmenu = strmenu.replaceAll('LUGAR1', `<li class="nav-item menu_item">
                    <a class="nav-link" href="REPLACElogin" method="get">Login</a>
                </li>
					`);
    }
    strmenu += `</ul>
				        </div>
				    </nav>
				</header>
				`;
    if (bool) {
        strmenu = strmenu.replaceAll('REPLACE', '../');
    } else {
        strmenu = strmenu.replaceAll('REPLACE', '');
    }
    tela.innerHTML = strmenu;
}

function setUserLS(user) {
    localStorage.setItem('currentUser', JSON.stringify(user));
}

function setProdLS(prod) {
    localStorage.setItem('currentProd', JSON.stringify(prod));
}


function getUserLS() {
    let user = localStorage.getItem('currentUser');
    if (user == null) {
        user = [];
    }
    return JSON.parse(user);
}

function getProdLS() {
    let prod = localStorage.getItem('currentProd');
    if (prod == null) {
        prod = [];
    }
    return JSON.parse(prod);
}

function logOut(pagina) {
    setUserLS(null);
    if (pagina) {
        window.location.href = pagina;
    } else {
        window.location.href = "index.html";
    }
}

function setMercadosLS(mercados)
{
	localStorage.setItem('mercados', JSON.stringify(mercados));
}

function getMercadosLS()
{
	let mercados = localStorage.getItem('mercados');
	if(mercados==null)
	{
		mercados = [];
	} 
	return JSON.parse(mercados);
}

function dropdownMercados()
{
	let mercados = getMercadosLS();
	let tela = document.getElementById('dropdownMercados');
	
	let code = `<form action="ocr" method="post" enctype="multipart/form-data">
            <label for="mercado">Estabelecimento:</label><br>
            <select name="mercado">
`;
	for(i=0; i<mercados.length - 1; i++)
	{
		code += `<option value="${mercados[i].id}">${mercados[i].nome} - ${mercados[i].bairro} - ${mercados[i].cidade} - ${mercados[i].estado}</option>
`;
	}

		code += `</select>
			<br><br>
            <input type="hidden" name="MAX_FILE_SIZE" value="4194304" />
            <input type="file" name="uploaded_file" class="btn_arquivo"/>

            <button type="submit" class="btn btn-primary" id="btn-send">Enviar</button>
		</form>`;
		
		tela.innerHTML = code;
}

// ------------------- Search ----------------------

function leProdutos() {
    let strDados = localStorage.getItem('currentProd');
    let objDados = {};
    objDados = JSON.parse(strDados);
    salvaProdutos(objDados);
    return objDados;
}
function salvaProdutos(dados) {
    localStorage.setItem('currentProd', JSON.stringify(dados));
}
function leMercados() {
    let strDados = localStorage.getItem('mercados');
    let objDados = {};
    objDados = JSON.parse(strDados);
    salvaMercados(objDados);
    return objDados;
}
function salvaMercados(dados) {
    localStorage.setItem('mercados', JSON.stringify(dados));
}
function stringPadrao(string) {

    string = string.normalize('NFD').replace(/[\u0300-\u036f]/g, "");
    string = string.toLowerCase()
    return string;
}

function filtraProdutos() {
    let objDados = leProdutos();
    let produtoPesquisado = stringPadrao(document.getElementById('pesquisaMercado').value);
    let strHtml = '';
    console.log(produtoPesquisado);
    console.log(objDados[1].nome);
    let tela = document.getElementById('tela');

    for (let i = 0; i < objDados.length - 1; i++) {
        const prod = objDados[i];


        if (stringPadrao(prod.nome).indexOf(produtoPesquisado) >= 0 || produtoPesquisado == '' ||
            stringPadrao(prod.categoria).indexOf(produtoPesquisado) >= 0 ||
            stringPadrao(prod.marca).indexOf(produtoPesquisado) >= 0 && (prod.Mercado == selecionado || selecionado == '')) {

            strHtml +=
                `
                    <div class="col-12 col-sm-12 col-md-6 col-lg-4 box-produto noUnderline">
                        <div class="produto">
                            <a href="produtos/${objDados[i].id}">
                                <h1>${objDados[i].nome}</h1>
                                <p>${objDados[i].categoria}</p>
                            <img src="${objDados[i].imagem}">
                            </a>
                            <a href="produtos/${objDados[i].id}"><button type="button" class="btn btn-secondary" id="btn_oferta">Ver Ofertas</button></a>
                        </div>
                    </div>
                `
        }

    }

    tela.innerHTML = strHtml;

}

function filtraMercado() {
    let objDados = leMercados();
    let mercadoPesquisado = stringPadrao(document.getElementById('pesquisaMercado').value);
    let strHtml = '';
    let tela = document.getElementById('tela');

    for (let i = 0; i < objDados.length - 1; i++) {
        const mercado = objDados[i];


        if (stringPadrao(mercado.nome).indexOf(mercadoPesquisado) >= 0 || mercadoPesquisado == ''
            && (mercado.Mercado == selecionado || selecionado == '')) {

            strHtml +=
                `
                <div class="col-12 col-sm-12 col-md-6 col-lg-4">
                <div class="mercado noUnderline">
                    <a href="mercados/${objDados[i].id}">
                        <h1>${objDados[i].nome}</h1>
                    </a>
                    <hr>
                    <a href="mercados/${objDados[i].id}">
                    <img src="${objDados[i].imagem}">
                    </a>
                    <hr>
                    <p style="color: grey;">${objDados[i].cidade} - ${objDados[i].estado}<br>${objDados[i].bairro}</p>
                </div>
            </div>
                `
        }

    }

    tela.innerHTML = strHtml;

}
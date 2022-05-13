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
                <p>${produto.marca} - ${produto.unidade} <br> categoria: ${produto.categoria} <br> ${produto.descricao}</p>
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
                <p>${produto[i].categoria}</p>
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
                        <input type="text" name="username" id="user1" class="form-control" value="${user.login}" class = "edit">
                        <label for="username">Novo nome de Usuário</label><br>
                        <input type="text" name="newusername" id="user" class="form-control" placeholder="Novo nome de usuário" class = "edit">
                        <label for="username">Senha</label><br>
                        <input type="password" name="password" id="senha" class="form-control" placeholder="Senha">
                        <input type="submit" value="Alterar Usuário" class="btn btn-primary" id="btn-cad"> </form>   
                    </div>`

    strhtml2 += `
                        <h1>Editar Senha</h1>
                        <form action="/edit/senha" method="post">
                        <input type="text" name="username" id="user1" class="form-control" value="${user.login}" class = "edit">   
                        <label for="username">Senha antiga</label><br>
                        <input type="password" name="oldpassword" id="senhaAntiga" class="form-control" placeholder="Senha">
                        <label for="password">Nova senha</label><br>
                        <input type="password" name="password" id="senhaNova" class="form-control" placeholder="Senha">
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
                    <a class="nav-link">|</a>
                </li>
                <li class="nav-item menu_item">
                    <a class="nav-link" href="REPLACEmercados" method="get">Supermercados</a>
                <li class="nav-item menu_item">
                    <a class="nav-link">|</a>
                </li>
                <li class="nav-item menu_item">
                    <a class="nav-link" href="REPLACElogin" method="get">Login</a>
                </li>`;
    let user = getUserLS();
    if (user && user.tipo == 'a') {
        strmenu += `
		            <li class="nav-item menu_item">
                        <a class="nav-link">|</a>
                	</li>
				    <li class="nav-item menu_item">
                        <a class="nav-link" href="REPLACEmercado">AdcMarket</a>
                    </li>`;
        strmenu += `
				    <li class="nav-item menu_item">
                        <a class="nav-link">|</a>
                	</li>
                    <li class="nav-item menu_item">
                        <a class="nav-link" href="REPLACEproduto">AdcProduct</a>
                    </li>`;
    }
    strmenu += `
				<li class="nav-item menu_item">
                    <a class="nav-link">|</a>
                </li>
                <li class="nav-item menu_item">
                    <a class="nav-link" onClick="logOut('${pagina}')" href="index.html">LogOut</a>
                </li>
                <li class="nav-item menu_item">
                    <a class="nav-link">|</a>
                	</li>
                <li class="nav-item menu_item">
                    <a class="nav-link" href="edit" method="get">${user.login}</a>
                </li>
				            </ul>
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

function getUserLS() {
    let user = localStorage.getItem('currentUser');
    return JSON.parse(user);
}

function logOut(pagina) {
    setUserLS(null);
    if (pagina) {
        window.location.href = pagina;
    } else {
        window.location.href = "index.html";
    }
}
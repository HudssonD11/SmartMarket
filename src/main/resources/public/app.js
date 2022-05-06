function mostrarMercados(mercados) {
    let tela = document.getElementById('tela');
    let strHtml = '';

    for (i = 0; i < mercados.length - 1; i++) {
        strHtml += `<div class="col-12 col-sm-12 col-md-6 col-lg-4">
        <div class="mercado">
            <a href="">
                <h1>${mercados[i].nome}</h1>
            </a>
            <img src="${mercados[i].imagem}">
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
            <div class="col-12 col-sm-12 col-md-6 col-lg-4 box-produto">
                <div class="produto">
                    <a href="ViewProduct2.html">
                        <h1>${produtos[i].nome}</h1>
                        <p>${produtos[i].categoria}</p>
                    </a>
                    <img src="${produtos[i].imagem}">
                    <a href="ViewProduct2.html"><button type="button" class="btn btn-secondary" id="btn_oferta">Ver Ofertas</button></a>
                </div>
            </div>
            `
    }
    tela.innerHTML = strHtml;
}

function mostrarMercado(mercado, produtos) {
    let tela = document.getElementById('tela');
    let supermercado = document.getElementById('mercado');
    let str2html = `    
    <div class="col-12 col-sm-12 col-md-12 col-lg-6 publicidade_produtos">
                    <img src="${mercado.imagem}" class="logo">
                </div>
                <div class="col-12 col-sm-12 col-md-12 col-lg-6 publicidade_produtos">
                  <h1>${mercado.nome}</h1>
                  <p>Estamos localizados no endereço: Rua ${mercado.rua} - ${mercado.numero}, ${mercado.bairro}, ${mercado.cidade} - ${mercado.estado}</p>
    </div>
    `;
    let strhtml = '';
    for(i = 0; i<produtos.length - 1; i++)
    {
        strhtml += `
        <div class="col-12 col-sm-12 col-md-12 col-lg-4 box-produto">
        <div class="produto">
            <a href="#">
                <h1>${produtos[i].nome}</h1>
                <p>${produtos[i].categoria}</p>
            </a>
            <img src="${produtos[i].imagem}">
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
            <a href="#">
                <h1>${produto.nome}</h1>
                <p>${produto.descricao} - ${produto.categoria} - ${produto.marca} - ${produto.unidade}</p>
            </a>
            <img src="${produto.imagem}">
        </div>
    </div>
    <div class="col-12 col-sm-12 col-md-12 col-lg-7 linha">
    `;

    for(i = 0; i<mercados.length - 1; i++)
    {
        strhtml += `<p class="Supermercado">${mercados[i].nome}</p>
        `;
    }
    strhtml += `</div><div class="col-12 col-sm-12 col-md-12 col-lg-2 linha">`;
    for(i = 0; i<mercados.length - 1; i++)
    {
        strhtml += `<p class="Supermercado">R$${mercados[i].preco}</p>`;
    }
    strhtml += `</div>`;
    
        
//   strhtml += `<div class="col-12 col-sm-12 col-md-12 col-lg-6 publicidade_produtos">
//                     <img src="#" class="logo">
//                 </div>
//                 <div class="col-12 col-sm-12 col-md-12 col-lg-6 publicidade_produtos">
//                   <h1>${mercado[i].nome}</h1>
//                   <p>Estamos localizados no endereço: Rua ${mercado[i].rua} - ${mercado[i].numero}, ${mercado[i].bairro}, ${mercado[i].cidade} - ${mercado[i].estado}</p>
//                 </div>`
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

function setUserLS(user) {
    localStorage.setItem('currentUser', JSON.stringify(user));
}

function getUserLS() {
    let user = localStorage.getItem('currentUser');
    return JSON.parse(user);
}

function logouAgora(user) {
    if (user.length > 0) {
        setUserLS(user);
        alert('logado');
        //idAdmin();
    } else {
        alert('nao logado');
    }
}
function mostrarMercados(mercados)
{
    let tela = document.getElementById('tela');
    let strHtml = '';
    
    for(i = 0; i<mercados.length-1; i++)
    {
        strHtml += `<div class="col-12 col-sm-12 col-md-6 col-lg-4">
        <div class="mercado">
            <a href="ShowMarket2.html">
                <h1>${mercados[i].nome}</h1>
            </a>
            <img src="img/ApoioMineiro.png">
        </div>
    </div> `;
    }
    tela.innerHTML = strHtml;
}

function setUserLS(user)
{
    localStorage.setItem('currentUser', JSON.stringify(user));
}

function getUserLS()
{
    let user = localStorage.getItem('currentUser');
    return JSON.parse(user);
}

function logouAgora(user)
{
    if(user.length>0)
    {
        setUserLS(user);
        alert('logado');
        //idAdmin();
    } else 
    {
        alert('nao logado');
    }
}
import React from 'react';
import Banner from '../assets/img/banner.svg';

const Home = () => {
    return (
        
        // es lo mismo que envolver los elementos html en <></>
        // ya que react necesita un "contenedor padre" para devolver mas de un elemento html
        <React.Fragment> 

        <header>
            <p>LOGO3DCELIA</p>


        </header>

        <section>
            <h1 className="text-3xl text-white underline">Home</h1>
            <img src={Banner} alt="Banner" />
        </section>

        </React.Fragment>
        
    )
}

export default Home;
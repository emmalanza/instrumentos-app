import React from 'react';
import { Link } from 'react-router-dom';
import Banner from '../assets/img/banner.svg';
import Guitarra from '../assets/img/guitarra.svg';
import Piano from '../assets/img/piano.svg';
import Copy from '../assets/img/copy.svg';
import GitHub from '../assets/img/github.svg';

const Home = () => {
    const instrumentos = [
        {
            id: 1,
            name: 'piano',
            img: Piano
        },
        {
            id: 2,
            name: 'guitarra',
            img: Guitarra
        }
    ]

    return (

        // es lo mismo que envolver los elementos html en <></>
        // ya que react necesita un "contenedor padre" para devolver mas de un elemento html
        <React.Fragment>

            <header className='absolute top-0 left-0 right-0 z-50 w-full
            text-white p-9
            flex items-center justify-between'>
                <p className='font-advent-pro'>LOGO3DCELIA</p>
                <nav>
                    <span className='font-advent-pro uppercase text-lg hover-underline'> <Link to="/grabaciones">Grabaciones</Link></span>
                </nav>

            </header>

            <section class='relative shadow-black shadow-2xl'>
                <h1 className="absolute top-1/2 left-1/2 transform -translate-x-1/2 -translate-y-1/2
                tracking-wider leading-15 drop-shadow-lg
                text-5xl first-letter:text-6xl font-anton-sc font-extrabold text-bright-yellow text-center uppercase
                max-w-xl">
                    ¡Aprende a tocar música a tu ritmo!</h1>
                <img src={Banner} alt="Banner"
                    className='w-full h-full p-0 m-0' />
            </section>


            <main className='flex flex-col items-center justify-center py-32 gap-10'>
                <h2 className='text-4xl font-anton-sc text-white text-center tracking-wide'>¡Elige tu instrumento!</h2>
                <ul className="grid grid-cols-2 gap-14 max-w-[800px]">
                    {instrumentos.map((instrumento) => (
                        instrumento.name === 'guitarra' ? (
                            <li key={instrumento.id} className="relative flex flex-col justify-center items-center
                            bg-gray-1 opacity-40
                            w-40 h-40 rounded-full">
                                <img src={instrumento.img} alt={instrumento.name} className="w-50 h-50" />
                                <span className="absolute bottom-0 
                                    text-5xl text-white font-anton-sc tracking-wide drop-shadow-lg">{instrumento.name}</span>
                                <span className="absolute bottom-10 transform rotate-[-8deg] text-4xl text-dark-pink font-anton-sc tracking-wide">
                                    Proximamente
                                </span>

                            </li>
                        ) : (
                            <li key={instrumento.id} className='transform transition duration-300 ease-in-out hover:scale-110'>
                                <Link to={`/${instrumento.name}`} className="relative flex flex-col justify-center items-center
                            bg-gray-1
                            w-40 h-40 rounded-full">
                                    <img src={instrumento.img} alt={instrumento.name} className="w-50 h-50" />
                                    <span className="absolute bottom-0 
                                    text-5xl text-white font-anton-sc tracking-wide drop-shadow-2xl">{instrumento.name}</span>
                                </Link>
                            </li>
                        )
                    ))}
                </ul>

            </main>

            <footer className='flex justify-between items-center p-9 h-32
            bg-black'>
                <div className='flex gap-1
                text-white font-advent-pro'>
                <p>bugNbass</p>
                <img src={Copy} alt='copy' className='w-3 h-3'/>
                <p>2025</p>
                </div>

                <a href="https://github.com/emmalanza/instrumentos-app" target="_blank" rel="noopener noreferrer"
                className='transform transition duration-300 ease-in-out hover:scale-110'>
                    <img src={GitHub} alt="GitHub" className='w-12 h-10' />
                </a>
            </footer>

        </React.Fragment>

    )
}

export default Home;
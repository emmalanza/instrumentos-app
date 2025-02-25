import React from 'react';
import { Link } from 'react-router-dom';

const Header = () => {
    return (

        <header className='absolute top-0 left-0 right-0 z-50 w-full
        text-white p-9 flex items-center justify-between'>
                <p className='font-advent-pro'>LOGO3DCELIA</p>
                <nav>
                    <span className='font-advent-pro uppercase text-lg hover-underline'> <Link to="/grabaciones">Grabaciones</Link></span>
                </nav>

        </header>
    )
}

export default Header;
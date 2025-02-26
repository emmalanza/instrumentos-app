import { useState } from 'react';
import ComponentePiano from "../components/piano/Piano";

import Grabacion from "../components/piano/Grabacion";



const Piano = () => {
   

    return (
        <div>
            <div className="cronometro-container bg-black text-white text-2xl  border  border-b-gray-1 p-2 rounded">
                <Grabacion />
            </div>
            <ComponentePiano />
        </div>
    );
};

export default Piano;
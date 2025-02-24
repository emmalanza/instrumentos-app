import { useState, useEffect } from 'react';

const Cronometro = ({ recording }) => {
    const [time, setTime] = useState(0);

    useEffect(() => {
        let interval;

        if (recording) {
            interval = setInterval(() => {
                setTime(prevTime => prevTime + 1);
            }, 1000); 
        } else {
            clearInterval(interval); 
            setTime(0); 
        }

        return () => clearInterval(interval); 
    }, [recording]); 

    const formatTime = (time) => {
        const minutes = Math.floor(time / 60);
        const seconds = time % 60;
        return `${minutes.toString().padStart(2, '0')}:${seconds.toString().padStart(2, '0')}`;
    };

    return (
        <div>
            {formatTime(time)}
        </div>
    );
};

export default Cronometro;
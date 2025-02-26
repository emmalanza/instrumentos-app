import { useState, useEffect } from 'react';

const Cronometro = ({ isRecording }) => {
    const [time, setTime] = useState(0);

    useEffect(() => {
        let interval;

        if (isRecording) {
            interval = setInterval(() => {
                setTime(prev => prev + 0.1);
            }, 100); 
        } else {
            clearInterval(interval); 
            setTime(0); 
        }

        return () => clearInterval(interval); 
    }, [isRecording]); 

    const formatTime = (time) => {
        const minutes = Math.floor(time / 60);
        const seconds = Math.floor(time % 60);
        const milliseconds = Math.floor((time * 1000) % 1000);
        return `${minutes.toString().padStart(2, '0')}:` +
               `${seconds.toString().padStart(2, '0')}:` +
               `${milliseconds.toString().padStart(3, '0')}`;
    };

    return (
        <div>
            ⏱️{formatTime(time)}
        </div>
    );
};

export default Cronometro;
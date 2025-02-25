import { useState } from "react";
import Cronometro from "./Cronometro";
import recordButton from "/src/assets/img/recordButton.svg";
import * as Tone from "tone";

const Grabacion = () => {
  const [recording, setRecording] = useState(false);
  const [notes, setNotes] = useState([]);

  const synth = new Tone.Synth().toDestination();

  const handleNotePlay = (note) => {
    synth.triggerAttackRelease(note, "8n");

    if (recording) {
      setNotes((prev) => [...prev, { note, timestamp: Date.now() }]);
    }
  };

  const startRecording = () => {
    setNotes([]);
    setRecording(true);
  };

  const stopRecording = async () => {
    setRecording(false);
    
    // Aquí puedes volver a habilitar la petición si la necesitas
    /* await fetch("http://localhost:8080/saveRecording", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ notes }),
    }); */
  };

  return (
    <div>
      <div>
        <Cronometro isRecording={recording} />
      </div>

      <button onClick={startRecording}>
        <img src={recordButton} alt="Grabar" />
      </button>

      <button onClick={stopRecording}>
        ⏹️ 
      </button>

      <div>
        {[].map((note) => (
          <button key={note} onClick={() => handleNotePlay(note)}>
            {note}
          </button>
        ))}
      </div>
    </div>
  );
};

export default Grabacion;

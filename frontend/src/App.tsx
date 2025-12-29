import { useState } from "react";
import "./index.css";

function App() {
  const [originalUrl, setOriginalUrl] = useState("");
  const [shortUrl, setShortUrl] = useState("");

  async function encurtarUrl() {
    if (!originalUrl.trim()) {
      alert("Cole uma URL válida");
      return;
    }

    try {
      const response = await fetch("http://localhost:8080/api/urls", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ originalUrl }),
      });

      if (!response.ok) {
        throw new Error("Erro ao encurtar URL");
      }

      const data = await response.json();
      setShortUrl(data.shortUrl);
    } catch (error) {
      console.error(error);
      alert("Erro ao conectar com o backend");
    }
  }

  return (
    <div className="container">
      <h1>🔗 Encurtador de URL</h1>

      <input
        type="text"
        placeholder="Cole a URL aqui..."
        value={originalUrl}
        onChange={(e) => setOriginalUrl(e.target.value)}
      />

      <button onClick={encurtarUrl}>Encurtar</button>

      {shortUrl && (
        <div className="result">
          <p>URL encurtada:</p>
          <a
            href={`http://localhost:8080/api/r/${shortUrl}`}
            target="_blank"
            rel="noopener noreferrer"
          >
            http://localhost:8080/api/r/{shortUrl}
          </a>
        </div>
      )}
    </div>
  );
}

export default App;

import React from "react";
import GraphDisplay from "./GraphDisplay.js";

function App() {
  return (
    <div className="container">
      <div class="row justify-content-md-center">
        <h1 className="display-4">Stack Data</h1>
      </div>
      <div class="row justify-content-md-center">
        <h4 className="lead text-muted">
          Breaking down the Stack Overflow 2018 Developer Survey
        </h4>
      </div>
      <GraphDisplay />
    </div>
  );
}

export default App;

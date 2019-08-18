import React from "react";
import GraphDisplay from "./GraphDisplay.js";

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      graphs: 0
    };

    this.handleAddGraph = this.handleAddGraph.bind(this);
  }

  handleAddGraph(event) {
    this.setState({
      graphs: this.state.graphs + 1
    });
  }

  render() {
    const graphs = [];
    for (var i = 0; i < this.state.graphs; i += 1) {
      graphs.push(<GraphDisplay number={i} />);
    }

    return (
      <div className="container">
        <div className="row justify-content-md-center">
          <h1 className="display-4">Stack Data</h1>
        </div>
        <div className="row justify-content-md-center">
          <h4 className="lead text-muted">
            Breaking down the Stack Overflow 2018 Developer Survey
          </h4>
        </div>
        {graphs}
        <br />
        <div className="col text-center">
          <button
            type="button"
            class="btn btn-success"
            onClick={this.handleAddGraph}
          >
            Add Graph
          </button>
        </div>
        <br />
      </div>
    );
  }
}

export default App;

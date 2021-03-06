import React from "react";
import GraphDisplay from "./GraphDisplay.js";

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      graphs: 0
    };

    this.handleAddGraph = this.handleAddGraph.bind(this);
    this.handleRemoveGraph = this.handleRemoveGraph.bind(this);
  }

  handleAddGraph(event) {
    this.state.graphs < 6
      ? this.setState({
          graphs: this.state.graphs + 1
        })
      : alert("You can't add any more graphs. 6 is the maximum.");
  }

  handleRemoveGraph(event) {
    this.setState({
      graphs: this.state.graphs - 1
    });
  }

  render() {
    const graphs = [];
    const colors = [
      "#33b5e5",
      "#ff4444",
      "#00C851",
      "#ffbb33",
      "#2BBBAD",
      "#aa66cc"
    ];
    for (var i = 0; i < this.state.graphs; i += 1) {
      graphs.push(
        <GraphDisplay number={i} languages={colors[i]} frameworks={colors[i]} />
      );
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
        {this.state.graphs > 0 ? (
          <div>
            <div className="col text-center">
              <button
                type="button"
                class="btn btn-outline-danger"
                onClick={this.handleRemoveGraph}
              >
                Remove Graph
              </button>
            </div>
            <br />
          </div>
        ) : (
          <div />
        )}
        <div className="col text-center">
          <button
            type="button"
            class="btn btn-outline-success"
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

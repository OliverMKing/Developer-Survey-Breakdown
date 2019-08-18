import React from "react";
import axios from "axios";
import Chart from "react-google-charts";

class GraphDisplay extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      data: [
        [
          "",
          "Number of developers",
          { role: "style" },
          {
            sourceColumn: 0,
            role: "annotation",
            type: "string",
            calc: "stringify"
          }
        ]
      ],
      loaded: false
    };
    this.handleClick = this.handleClick.bind(this);
  }

  componentDidMount() {
    axios.get("http://localhost:8080/api/v1/responses/stats").then(response => {
      let lang_data = [this.state.data[0]];
      for (const [language, count] of Object.entries(response.data.languages)) {
        const row = [language, count, "#007bff", null];
        lang_data.push(row);
      }
      this.setState({
        data: lang_data,
        loaded: true
      });
    });
  }

  handleClick() {
    axios.get("http://localhost:8080/api/v1/responses/stats").then(response => {
      let lang_data = [this.state.data[0]];
      for (const [language, count] of Object.entries(response.data.languages)) {
        const row = [language, count, "#007bff", null];
        lang_data.push(row);
      }
      this.setState({
        data: lang_data
      });
    });
  }

  render() {
    if (this.state.loaded) {
      return (
        <div>
          <h2>Languages</h2>
          <Chart
            width={"500px"}
            height={"750px"}
            chartType="Bar"
            loader={<div>Loading Chart</div>}
            data={this.state.data}
            options={{
              hAxis: {
                title: "Developers",
                minValue: 0
              },
              vAxis: {
                title: "Languages"
              },
              bars: "horizontal",

              axes: {
                y: {
                  0: { side: "left" }
                }
              },
              legend: { position: "none" }
            }}
          />
          <button
            type="button"
            className="btn btn-primary"
            onClick={this.handleClick}
          >
            Test
          </button>
        </div>
      );
    } else {
      return <div>Loading...</div>;
    }
  }
}

export default GraphDisplay;

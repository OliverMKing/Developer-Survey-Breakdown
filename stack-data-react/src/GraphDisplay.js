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
      loaded: false,
      call: "http://localhost:8080/api/v1/responses/stats?",
      country: "",
      education: "",
      devType: "",
      yearsCoding: "",
      jobSatisfaction: "",
      salaryGreaterThan: ""
    };
  }

  componentDidMount() {
    this.callAPI();
  }

  callAPI() {
    axios.get(this.generateCall()).then(response => {
      let lang_data = [this.state.data[0]];
      for (const [language, count] of Object.entries(response.data.languages)) {
        const row = [language, count, "#007bff", null];
        lang_data.push(row);
      }
      this.setState({
        data: lang_data,
        loaded: true,
        call: this.state.call,
        country: this.state.country,
        education: this.state.education,
        devType: this.state.devType,
        yearsCoding: this.state.yearsCoding,
        jobSatisfaction: this.state.jobSatisfaction,
        salaryGreaterThan: this.state.salaryGreaterThan
      });
    });
  }

  generateCall() {
    let call = this.state.call;
    let params = 0;

    if (this.state.country) {
      if (params > 0) {
        call += "&";
      }
      call += "country=" + this.state.country;
      params += 1;
    }
    if (this.state.education) {
      if (params > 0) {
        call += "&";
      }
      call += "formalEducation=" + this.state.education;
      params += 1;
    }
    if (this.state.devType) {
      if (params > 0) {
        call += "&";
      }
      call += "devType=" + this.state.devType;
      params += 1;
    }
    if (this.state.yearsCoding) {
      if (params > 0) {
        call += "&";
      }
      call += "yearsCoding=" + this.state.yearsCoding;
      params += 1;
    }
    if (this.state.jobSatisfaction) {
      if (params > 0) {
        call += "&";
      }
      call += "jobSatisfaction=" + this.state.jobSatisfaction;
      params += 1;
    }
    if (this.state.salaryGreaterThan) {
      if (params > 0) {
        call += "&";
      }
      call += "salaryGreaterThan=" + this.state.salaryGreaterThan;
      params += 1;
    }

    return call;
  }

  render() {
    if (this.state.loaded) {
      return (
        <div>
          <h2>Languages</h2>

          <label for="country">Country</label>
          <select className="form-control" id="country">
            <option>All</option>
            <option>U.S.</option>
          </select>

          <label for="education">Education</label>
          <select className="form-control" id="education">
            <option>All</option>
            <option>BS</option>
            <option>BA</option>
          </select>

          <label for="devType">Developer Type</label>
          <select className="form-control" id="devType">
            <option>All</option>
            <option>Full-stack</option>
            <option>Front-end</option>
          </select>

          <label for="yearsCoding">Years Coding</label>
          <select className="form-control" id="yearsCoding">
            <option>All</option>
            <option>0 - 1</option>
            <option>1+</option>
          </select>

          <label for="jobSatisfaction">Job Satisfaction</label>
          <select className="form-control" id="jobSatisfaction">
            <option>All</option>
            <option>Good</option>
            <option>Bad</option>
          </select>

          <label for="salaryGreaterThan">Salary Greater Than</label>
          <select className="form-control" id="salaryGreaterThan">
            <option>All</option>
            <option>$0</option>
            <option>$100</option>
          </select>

          <br />
          <Chart
            width={"300px"}
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
        </div>
      );
    } else {
      return <div>Loading...</div>;
    }
  }
}

export default GraphDisplay;

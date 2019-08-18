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
      country: "",
      education: "",
      devType: "",
      yearsCoding: "",
      jobSatisfaction: "",
      salaryGreaterThan: "",
      responseCountries: [],
      responseEducation: [],
      responseDevTypes: [],
      responseYearsCoding: [],
      responseSatisfactions: []
    };

    this.handleCountryChange = this.handleCountryChange.bind(this);
  }

  componentDidMount() {
    this.initialCallAPI();
  }

  initialCallAPI() {
    axios.get(this.generateCall()).then(response => {
      let langData = [this.state.data[0]];
      for (const [language, count] of Object.entries(response.data.languages)) {
        const row = [language, count, "#007bff", null];
        langData.push(row);
      }

      const countries = Object.keys(response.data.countries);
      const education = Object.keys(response.data.education);
      const devTypes = Object.keys(response.data.devTypes);
      const yearsCoding = Object.keys(response.data.yearsCoding);
      const satisfactions = Object.keys(response.data.jobSatisfactions);

      this.setState({
        data: langData,
        loaded: true,
        country: this.state.country,
        education: this.state.education,
        devType: this.state.devType,
        yearsCoding: this.state.yearsCoding,
        jobSatisfaction: this.state.jobSatisfaction,
        salaryGreaterThan: this.state.salaryGreaterThan,
        responseCountries: countries,
        responseEducation: education,
        responseDevTypes: devTypes,
        responseYearsCoding: yearsCoding,
        responseSatisfactions: satisfactions
      });
    });
  }

  callAPI() {
    axios.get(this.generateCall()).then(response => {
      let langData = [this.state.data[0]];
      for (const [language, count] of Object.entries(response.data.languages)) {
        const row = [language, count, "#007bff", null];
        langData.push(row);
      }

      this.setState({
        data: langData,
        loaded: true,
        country: this.state.country,
        education: this.state.education,
        devType: this.state.devType,
        yearsCoding: this.state.yearsCoding,
        jobSatisfaction: this.state.jobSatisfaction,
        salaryGreaterThan: this.state.salaryGreaterThan,
        responseCountries: this.state.responseCountries,
        responseEducation: this.state.responseEducation,
        responseDevTypes: this.state.responseDevTypes,
        responseYearsCoding: this.state.responseYearsCoding,
        responseSatisfactions: this.state.responseSatisfactions
      });
    });
  }

  generateCall() {
    let call = "http://localhost:8080/api/v1/responses/stats?";
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

  handleCountryChange(event) {
    this.setState(
      {
        data: this.state.data,
        loaded: false,
        country: event.target.value,
        education: this.state.education,
        devType: this.state.devType,
        yearsCoding: this.state.yearsCoding,
        jobSatisfaction: this.state.jobSatisfaction,
        salaryGreaterThan: this.state.salaryGreaterThan,
        responseCountries: this.state.responseCountries,
        responseEducation: this.state.responseEducation,
        responseDevTypes: this.state.responseDevTypes,
        responseYearsCoding: this.state.responseYearsCoding,
        responseSatisfactions: this.state.responseSatisfactions
      },
      this.callAPI
    );
  }

  render() {
    if (this.state.loaded) {
      console.log(this.state.country);
      return (
        <div>
          <h2>Languages</h2>

          <label>Country</label>
          <select
            className="form-control"
            id="country"
            onChange={this.handleCountryChange}
          >
            <option>{this.state.country}</option>
            <option />
            {this.state.responseCountries.map(value => {
              return <option>{value}</option>;
            })}
          </select>

          <label>Education</label>
          <select className="form-control" id="education">
            <option>{this.state.education}</option>
            <option />
          </select>

          <label>Developer Type</label>
          <select className="form-control" id="devType">
            <option>{this.state.devType}</option>
            <option />
          </select>

          <label>Years Coding</label>
          <select className="form-control" id="yearsCoding">
            <option>{this.state.yearsCoding}</option>
            <option />
          </select>

          <label>Job Satisfaction</label>
          <select className="form-control" id="jobSatisfaction">
            <option>{this.state.jobSatisfaction}</option>
            <option />
          </select>

          <label>Salary Greater Than</label>
          <select className="form-control" id="salaryGreaterThan">
            <option>{this.state.salaryGreaterThan}</option>
            <option />
          </select>

          <br />
          <Chart
            width={"80%"}
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

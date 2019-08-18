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
      framework_data: [
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
      responseSatisfactions: [],
      responseCount: 0
    };

    this.handleCountryChange = this.handleCountryChange.bind(this);
    this.handleEducationChange = this.handleEducationChange.bind(this);
    this.handleDeveloperTypeChange = this.handleDeveloperTypeChange.bind(this);
    this.handleYearsCodingChange = this.handleYearsCodingChange.bind(this);
    this.handleJobSatisfactionChange = this.handleJobSatisfactionChange.bind(
      this
    );
    this.handleSalaryGreaterThanChange = this.handleSalaryGreaterThanChange.bind(
      this
    );
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

      let frameworkData = [this.state.framework_data[0]];
      for (const [framework, count] of Object.entries(
        response.data.frameworks
      )) {
        const row = [framework, count, "#007bff", null];
        frameworkData.push(row);
      }

      const countries = Object.keys(response.data.countries);
      const education = Object.keys(response.data.education);
      const devTypes = Object.keys(response.data.devTypes);
      const yearsCoding = Object.keys(response.data.yearsCoding);
      const satisfactions = Object.keys(response.data.jobSatisfactions);
      const responses = response.data.responseCount;

      this.setState({
        data: langData,
        framework_data: frameworkData,
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
        responseSatisfactions: satisfactions,
        responseCount: responses
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

      let frameworkData = [this.state.framework_data[0]];
      for (const [framework, count] of Object.entries(
        response.data.frameworks
      )) {
        const row = [framework, count, "#007bff", null];
        frameworkData.push(row);
      }

      const responses = response.data.responseCount;

      this.setState({
        data: langData,
        framework_data: frameworkData,
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
        responseSatisfactions: this.state.responseSatisfactions,
        responseCount: responses
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
        framework_data: this.state.framework_data,
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
        responseSatisfactions: this.state.responseSatisfactions,
        responseCount: this.state.responseCount
      },
      this.callAPI
    );
  }

  handleEducationChange(event) {
    this.setState(
      {
        data: this.state.data,
        framework_data: this.state.framework_data,
        loaded: false,
        country: this.state.country,
        education: event.target.value,
        devType: this.state.devType,
        yearsCoding: this.state.yearsCoding,
        jobSatisfaction: this.state.jobSatisfaction,
        salaryGreaterThan: this.state.salaryGreaterThan,
        responseCountries: this.state.responseCountries,
        responseEducation: this.state.responseEducation,
        responseDevTypes: this.state.responseDevTypes,
        responseYearsCoding: this.state.responseYearsCoding,
        responseSatisfactions: this.state.responseSatisfactions,
        responseCount: this.state.responseCount
      },
      this.callAPI
    );
  }

  handleDeveloperTypeChange(event) {
    this.setState(
      {
        data: this.state.data,
        framework_data: this.state.framework_data,
        loaded: false,
        country: this.state.country,
        education: this.state.education,
        devType: event.target.value,
        yearsCoding: this.state.yearsCoding,
        jobSatisfaction: this.state.jobSatisfaction,
        salaryGreaterThan: this.state.salaryGreaterThan,
        responseCountries: this.state.responseCountries,
        responseEducation: this.state.responseEducation,
        responseDevTypes: this.state.responseDevTypes,
        responseYearsCoding: this.state.responseYearsCoding,
        responseSatisfactions: this.state.responseSatisfactions,
        responseCount: this.state.responseCount
      },
      this.callAPI
    );
  }

  handleYearsCodingChange(event) {
    this.setState(
      {
        data: this.state.data,
        framework_data: this.state.framework_data,
        loaded: false,
        country: this.state.country,
        education: this.state.education,
        devType: this.state.devType,
        yearsCoding: event.target.value,
        jobSatisfaction: this.state.jobSatisfaction,
        salaryGreaterThan: this.state.salaryGreaterThan,
        responseCountries: this.state.responseCountries,
        responseEducation: this.state.responseEducation,
        responseDevTypes: this.state.responseDevTypes,
        responseYearsCoding: this.state.responseYearsCoding,
        responseSatisfactions: this.state.responseSatisfactions,
        responseCount: this.state.responseCount
      },
      this.callAPI
    );
  }

  handleJobSatisfactionChange(event) {
    this.setState(
      {
        data: this.state.data,
        framework_data: this.state.framework_data,
        loaded: false,
        country: this.state.country,
        education: this.state.education,
        devType: this.state.devType,
        yearsCoding: this.state.yearsCoding,
        jobSatisfaction: event.target.value,
        salaryGreaterThan: this.state.salaryGreaterThan,
        responseCountries: this.state.responseCountries,
        responseEducation: this.state.responseEducation,
        responseDevTypes: this.state.responseDevTypes,
        responseYearsCoding: this.state.responseYearsCoding,
        responseSatisfactions: this.state.responseSatisfactions,
        responseCount: this.state.responseCount
      },
      this.callAPI
    );
  }

  handleSalaryGreaterThanChange(event) {
    this.setState(
      {
        data: this.state.data,
        framework_data: this.state.framework_data,
        loaded: false,
        country: this.state.country,
        education: this.state.education,
        devType: this.state.devType,
        yearsCoding: this.state.yearsCoding,
        jobSatisfaction: this.state.yearsCoding,
        salaryGreaterThan: event.target.value.replace(/[$,]+/g, ""),
        responseCountries: this.state.responseCountries,
        responseEducation: this.state.responseEducation,
        responseDevTypes: this.state.responseDevTypes,
        responseYearsCoding: this.state.responseYearsCoding,
        responseSatisfactions: this.state.responseSatisfactions,
        responseCount: this.state.responseCount
      },
      this.callAPI
    );
  }

  render() {
    if (this.state.loaded) {
      return (
        <div>
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
          <select
            className="form-control"
            id="education"
            onChange={this.handleEducationChange}
          >
            <option>{this.state.education}</option>
            <option />
            {this.state.responseEducation.map(value => {
              return <option>{value}</option>;
            })}
          </select>

          <label>Developer Type</label>
          <select
            className="form-control"
            id="devType"
            onChange={this.handleDeveloperTypeChange}
          >
            <option>{this.state.devType}</option>
            <option />
            {this.state.responseDevTypes.map(value => {
              return <option>{value}</option>;
            })}
          </select>

          <label>Years Coding</label>
          <select
            className="form-control"
            id="yearsCoding"
            onChange={this.handleYearsCodingChange}
          >
            <option>{this.state.yearsCoding}</option>
            <option />
            {this.state.responseYearsCoding.map(value => {
              return <option>{value}</option>;
            })}
          </select>

          <label>Job Satisfaction</label>
          <select
            className="form-control"
            id="jobSatisfaction"
            onChange={this.handleJobSatisfactionChange}
          >
            <option>{this.state.jobSatisfaction}</option>
            <option />
            {this.state.responseSatisfactions.map(value => {
              return <option>{value}</option>;
            })}
          </select>

          <label>Salary Greater Than</label>
          <select
            className="form-control"
            id="salaryGreaterThan"
            onChange={this.handleSalaryGreaterThanChange}
          >
            <option>{this.state.salaryGreaterThan}</option>
            <option />
            <option>$20,000</option>
            <option>$40,000</option>
            <option>$60,000</option>
            <option>$80,000</option>
            <option>$100,000</option>
            <option>$200,000</option>
            <option>$400,000</option>
            <option>$600,000</option>
            <option>$800,000</option>
            <option>$1,000,000</option>
            <option>$1,500,000</option>
            <option>$2,000,000</option>
          </select>

          {this.state.data.length > 1 ? (
            <div>
              <br />
              <h5 className="lead text-muted">
                Responses: {this.state.responseCount}
              </h5>
              <br />
              <div className="d-flex justify-content-between">
                <h1 className="lead text-muted">
                  <strong>Languages</strong>
                </h1>
                {this.state.framework_data.length > 1 ? (
                  <h1 className="lead text-muted">
                    <strong>Frameworks</strong>
                  </h1>
                ) : (
                  <div />
                )}
                <div />
              </div>

              <div className="d-flex justify-content-between">
                <Chart
                  width={"70%"}
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
                {this.state.framework_data.length > 1 ? (
                  <Chart
                    width={"70%"}
                    height={"750px"}
                    chartType="Bar"
                    loader={<div>Loading Chart</div>}
                    data={this.state.framework_data}
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
                ) : (
                  <h5 className="lead text-muted">
                    There are 0 framework results for those parameters
                  </h5>
                )}
              </div>
            </div>
          ) : (
            <div>
              <br />
              <h5 className="lead text-muted">
                There are 0 results for those parameters
              </h5>
            </div>
          )}
        </div>
      );
    } else {
      return <div>Loading...</div>;
    }
  }
}

export default GraphDisplay;

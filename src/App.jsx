import React from "react";
import Header from "./Components/Header/Header";
import { withRouter, Switch, Route, Redirect } from "react-router-dom";
import Home from "./Containers/Home/Home";
import ClientData from "./Containers/ClientData/ClientData";
import Purchase from "./Components/Purchase/Purchase";
import Result from "./Components/Result/Result";

class App extends React.Component {
	render() {
		return (
			<React.Fragment>
				<Header title="RUP Hotel" />
				<Switch>
					<Route exact path="/" component={Home} />
					<Route exact path="/client-data" component={ClientData} />
					<Route path="/result" component={Result} />
					<Redirect to="/" />
				</Switch>
			</React.Fragment>
		);
	}
}

export default withRouter(App);

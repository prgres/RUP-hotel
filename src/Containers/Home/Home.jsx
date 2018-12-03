import React from "react";
import SearchForm from "../../Components/SearchForm/SearchForm";
import "./Home.css";

class Home extends React.Component {
	constructor(props) {
		super(props);
		this.state = {
			chosenRoomOptions: {
				one: false,
				two: false,
				three: false,
				four: false,
			},
		};
		this.chooseRoomOptionHandler = this.chooseRoomOptionHandler.bind(this);
	}

	chooseRoomOptionHandler(option) {
		this.setState(state => ({
			chosenRoomOptions: {
				...state.chosenRoomOptions,
				[option]: !state.chosenRoomOptions[option],
			},
		}));
	}

	render() {
		return (
			<div className="home">
				<h2 className="home-heading">
					Znajdź pokój odpowiedni dla Ciebie
				</h2>
				<SearchForm
					options={this.state.chosenRoomOptions}
					chooseRoomOptionHandler={this.chooseRoomOptionHandler}
				/>
			</div>
		);
	}
}

export default Home;

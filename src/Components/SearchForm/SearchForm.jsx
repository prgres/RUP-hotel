import React from "react";
import PersonCounter from "../../Components/PersonCounter/PersonCounter";
import "./SearchForm.css";

function SearchForm(props) {
	return (
		<React.Fragment>
			<h3 className="home-form-heading">
				1. Wybierz termin który Cię interesuje
			</h3>
			<form className="home-form">
				<label htmlFor="date-from">
					<strong>Data przyjazdu</strong>
					<input
						type="date"
						id="date-from"
						placeholder="Data przyjazdu"
					/>
				</label>
				<label htmlFor="date-to">
					<strong>Data wyjazdu</strong>
					<input type="date" placeholder="Data wyjazdu" />
				</label>
				<div>
					<h3 className="home-form-heading">
						2. Wybierz liczbę osób
					</h3>
					<PersonCounter
						options={props.options}
						handler={props.chooseRoomOptionHandler}
					/>
				</div>
			</form>
			<button className="home-form-button">Szukaj</button>
		</React.Fragment>
	);
}

export default SearchForm;

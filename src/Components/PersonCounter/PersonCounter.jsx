import React from "react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faPersonBooth } from "@fortawesome/free-solid-svg-icons";
import "./PersonCounter.css";

function checkForActivity(option, info) {
	return { color: info[option] ? "#ce6c6c" : "#ffffff" };
}

function PersonCounter(props) {
	const { options } = props;

	const wordToNumbers = {
		one: 1,
		two: 2,
		three: 3,
		four: 4,
	};

	return (
		<ul className="home-personCount">
			{Object.keys(wordToNumbers).map((number, index) => {
				return (
					<li
						key={index}
						onClick={() => props.handler(number)}
						style={checkForActivity(number, options)}
					>
						<FontAwesomeIcon icon={faPersonBooth} />
						<span>{wordToNumbers[number]}</span>
					</li>
				);
			})}
		</ul>
	);
}

export default PersonCounter;

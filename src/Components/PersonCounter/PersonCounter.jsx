import React from "react";
import "./PersonCounter.css";

function PersonCounter(props) {
	const range = new Array(10).fill(0);

	return (
		<select className="personSelect" name="person-count">
			{range.map(function(x, index) {
				return (
					<option key={index} value={index + 1}>
						{index + 1}
					</option>
				);
			})}
		</select>
	);
}

export default PersonCounter;

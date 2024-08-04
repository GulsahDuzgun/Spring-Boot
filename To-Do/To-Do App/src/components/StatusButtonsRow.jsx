import { HiMiniPlus } from "react-icons/hi2";
import { HiBars4 } from "react-icons/hi2";
import { useTasks } from "../utils/ContextApi";
import { useState } from "react";

function StatusButtonsRow() {
  const { setIsFormOpen } = useTasks();
  const [isOpen, setIsOpen] = useState(false);

  function handleOpenForm() {
    setIsFormOpen((s) => !s);
  }

  return (
    <div className="btn__container">
      <button onClick={handleOpenForm} type="button" className="btn__add-task">
        <span className="icon">
          <HiMiniPlus className="icon--add" />
        </span>
        Add Task
      </button>
      <button className="btn__options">
        <HiBars4 />
      </button>
      <div className="btn__options--select">
        <button className="bnt__option">Delete All</button>
        <button className="bnt__option">Sort tasks</button>
      </div>
    </div>
  );
}

export default StatusButtonsRow;

import { HiMiniPlus } from "react-icons/hi2";
import { HiBars4 } from "react-icons/hi2";
import { useTasks } from "../utils/ContextApi";

function StatusButtonsRow() {
  const { setIsFormOpen } = useTasks();

  function handleOpenForm() {
    setIsFormOpen((s) => !s);
  }

  return (
    <div className='btn__container'>
      <button onClick={handleOpenForm} type='button' className='btn__add-task'>
        <span className='icon'>
          <HiMiniPlus className='icon--add' />
        </span>
        Add Task
      </button>
      <button className='btn__options'>
        <HiBars4 />
      </button>
    </div>
  );
}

export default StatusButtonsRow;

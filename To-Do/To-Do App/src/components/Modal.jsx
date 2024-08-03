import { useTasks } from "../utils/ContextApi";

export default function Modal(id, message, executedFunc) {
  const {
    isModalOpen,
    modalWord,
    setModalWord,
    currentTask,
    setCurrentTask,
    setIsModalOpen,
  } = useTasks();
  if (isModalOpen)
    return (
      <div className="modal__container">
        <div className="modal">
          <div className="modal__header">
            <p className="edited__taskName">{currentTask.taskName}</p>
            <span className="edited__taskStatus">
              {" "}
              {currentTask.taskStatus}
            </span>
          </div>
          <div className="modal__body">
            <p className="edited__task">{currentTask.task}</p>
          </div>
          <div className="modal__footer">
            <button onClick={() => setIsModalOpen((s) => !s)}>Cancel</button>
            <button onClick={() => executedFunc(id)}>{modalWord}</button>
          </div>
        </div>
      </div>
    );
}

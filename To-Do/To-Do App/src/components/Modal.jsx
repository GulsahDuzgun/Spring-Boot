import { useTasks } from "../utils/ContextApi";

const statusColors = {
  not_started: "#ff8787",
  in_progress: "#ffd43b",
  done: "#69db7c",
};

export default function Modal(id) {
  const { isModalOpen, currentTask } = useTasks();
  if (isModalOpen)
    return (
      <div className="modal__container">
        <div className="modal">
          <div className="modal__header">
            <p className="current__taskName">{currentTask.taskName}</p>
            <span
              className="current__taskStatus task__status"
              style={{
                backgroundColor:
                  statusColors[
                    `${currentTask?.statusName
                      ?.replace(" ", "_")
                      .toLowerCase()}`
                  ],
              }}
            >
              {" "}
              {currentTask.statusName}
            </span>
          </div>
          <div className="modal__body">
            <p className="current__task">{currentTask.task}</p>
          </div>
          <div className="modal__footer">
            <button
              className="btn__cancel"
              onClick={() => setIsModalOpen((s) => !s)}
            >
              Cancel
            </button>
            <button></button>
          </div>
        </div>
      </div>
    );
}

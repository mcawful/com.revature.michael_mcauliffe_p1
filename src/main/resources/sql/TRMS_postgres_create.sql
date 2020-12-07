CREATE TABLE "employee" (
	"employee_id" serial NOT NULL,
	"job_title" varchar(50) NOT NULL,
	"department" varchar(50) NOT NULL,
	"is_ben_co" BOOLEAN NOT NULL,
	"first_name" varchar(50) NOT NULL,
	"last_name" varchar(50) NOT NULL,
	"address" varchar(50),
	"city" varchar(50),
	"state" varchar(2),
	"postal_code" varchar(5),
	"phone_number" varchar(10),
	"email" varchar(50) NOT NULL,
	"reports_to" integer,
	"admin_level" integer NOT NULL,
	CONSTRAINT "employee_pk" PRIMARY KEY ("employee_id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "credential" (
	"employee_id" integer NOT NULL UNIQUE,
	"username" varchar(50) NOT NULL UNIQUE,
	"password" varchar(255) NOT NULL
) WITH (
  OIDS=FALSE
);



CREATE TABLE "request" (
	"request_id" varchar(16) NOT NULL UNIQUE,
	"employee_id" integer NOT NULL,
	"is_urgent" BOOLEAN NOT NULL,
	"description" varchar(255) NOT NULL,
	"event_type" varchar(50) NOT NULL,
	"location" varchar(50) NOT NULL,
	"cost" DECIMAL NOT NULL,
	"reimbursement" DECIMAL NOT NULL,
	"request_date" TIMESTAMP NOT NULL,
	"event_date_start" TIMESTAMP NOT NULL,
	"event_date_end" TIMESTAMP NOT NULL,
	"grade_format" varchar(50) NOT NULL,
	"grade_format_other" varchar(50),
	"passing_grade_other" varchar(50),
	"grade" bytea,
	"is_passing" BOOLEAN,
	"is_complete" BOOLEAN NOT NULL,
	CONSTRAINT "request_pk" PRIMARY KEY ("request_id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "message" (
	"message_id" serial NOT NULL,
	"request_id" varchar(16) NOT NULL,
	"sender_id" integer NOT NULL,
	"receiver_id" integer NOT NULL,
	"send_timestamp" TIMESTAMP NOT NULL,
	"message_text" TEXT NOT NULL,
	"is_read" BOOLEAN NOT NULL,
	CONSTRAINT "message_pk" PRIMARY KEY ("message_id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "attachment" (
	"attachment_id" serial NOT NULL,
	"request_id" varchar(16) NOT NULL,
	"file" bytea NOT NULL,
	"description" TEXT NOT NULL,
	CONSTRAINT "attachment_pk" PRIMARY KEY ("attachment_id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "approval" (
	"approval_id" serial NOT NULL,
	"request_id" varchar(16) NOT NULL UNIQUE,
	"first_approver_id" integer,
	"first_approval" BOOLEAN,
	"first_approval_date" TIMESTAMP,
	"second_approver_id" integer,
	"second_approval" BOOLEAN,
	"second_approval_date" TIMESTAMP,
	"final_approver_id" integer,
	"final_approval" BOOLEAN,
	"final_approval_date" TIMESTAMP,
	CONSTRAINT "approval_pk" PRIMARY KEY ("approval_id")
) WITH (
  OIDS=FALSE
);



ALTER TABLE "employee" ADD CONSTRAINT "employee_fk0" FOREIGN KEY ("reports_to") REFERENCES "employee"("employee_id");

ALTER TABLE "credential" ADD CONSTRAINT "credential_fk0" FOREIGN KEY ("employee_id") REFERENCES "employee"("employee_id");

ALTER TABLE "request" ADD CONSTRAINT "request_fk0" FOREIGN KEY ("employee_id") REFERENCES "employee"("employee_id");

ALTER TABLE "message" ADD CONSTRAINT "message_fk0" FOREIGN KEY ("request_id") REFERENCES "request"("request_id");
ALTER TABLE "message" ADD CONSTRAINT "message_fk1" FOREIGN KEY ("sender_id") REFERENCES "employee"("employee_id");
ALTER TABLE "message" ADD CONSTRAINT "message_fk2" FOREIGN KEY ("receiver_id") REFERENCES "employee"("employee_id");

ALTER TABLE "attachment" ADD CONSTRAINT "attachment_fk0" FOREIGN KEY ("request_id") REFERENCES "request"("request_id");

ALTER TABLE "approval" ADD CONSTRAINT "approval_fk0" FOREIGN KEY ("request_id") REFERENCES "request"("request_id");
ALTER TABLE "approval" ADD CONSTRAINT "approval_fk1" FOREIGN KEY ("first_approver_id") REFERENCES "employee"("employee_id");
ALTER TABLE "approval" ADD CONSTRAINT "approval_fk2" FOREIGN KEY ("second_approver_id") REFERENCES "employee"("employee_id");
ALTER TABLE "approval" ADD CONSTRAINT "approval_fk3" FOREIGN KEY ("final_approver_id") REFERENCES "employee"("employee_id");

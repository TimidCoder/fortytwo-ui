package com.arvatosystems.t9t.viewmodel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;

import com.arvatosystems.t9t.base.entities.FullTrackingWithVersion;
import com.arvatosystems.t9t.components.crud.CrudSurrogateKeyVM;
import com.arvatosystems.t9t.services.IT9TReportDAO;
import com.arvatosystems.t9t.ssm.SchedulerSetupDTO;
import com.arvatosystems.t9t.ssm.SchedulerSetupRecurrenceType;
import com.arvatosystems.t9t.ssm.SchedulerSetupRef;
import com.arvatosystems.t9t.ssm.SchedulerWeekDaysEnumSet;
import com.arvatosystems.t9t.tfi.services.ReturnCodeException;

import de.jpaw.dp.Jdp;

// viewModel only required for the button command. This could be done via context menu as well!

@Init(superclass=true)
public class SchedulerSetupViewModel extends CrudSurrogateKeyVM<SchedulerSetupRef, SchedulerSetupDTO, FullTrackingWithVersion> {
    private static final Logger LOGGER = LoggerFactory.getLogger(SchedulerSetupViewModel.class);

    protected final IT9TReportDAO t9tReportDAO = Jdp.getRequired(IT9TReportDAO.class);

    @Command
    public final void executeCannedRequest() throws ReturnCodeException {
        if (data == null || data.getRequest() == null)
            return;
        LOGGER.debug("executeCannedRequest with Ref {}", data.getRequest());
        t9tReportDAO.executeCannedRequest(data.getRequest());
    }

    @Override
    protected void saveHook() {
        //Reset some of the dirty fields while using CRON_NATIVE as the fields will not be reset when hidden
        if (this.data.getRecurrencyType().equals(SchedulerSetupRecurrenceType.CRON_NATIVE)) {
            this.data.setRepeatCount(null);
            this.data.setIntervalMilliseconds(null);
            this.data.setSetOfWeekdays(new SchedulerWeekDaysEnumSet());
            this.data.setExecutionTime(null);
            this.data.setStartHour(null);
            this.data.setEndHour(null);
            this.data.setIntervalMinutes(null);
            this.data.setIntervalOffset(null);
        } else {
            this.data.setCronExpression(null);

            if (!this.data.getRecurrencyType().equals(SchedulerSetupRecurrenceType.FAST)) {
                this.data.setRepeatCount(null);
                this.data.setIntervalMilliseconds(null);
            }

            if (!this.data.getRecurrencyType().equals(SchedulerSetupRecurrenceType.MONTHLY)
                    && !this.getData().getRecurrencyType().equals(SchedulerSetupRecurrenceType.YEARLY)) {
                this.data.setValidFrom(null);
                this.data.setValidTo(null);
            }

            if (!this.data.getRecurrencyType().equals(SchedulerSetupRecurrenceType.WEEKLY)) {
                this.data.setSetOfWeekdays(new SchedulerWeekDaysEnumSet());
            }

            if (!this.data.getRecurrencyType().equals(SchedulerSetupRecurrenceType.DAILY) &&
                    !this.data.getRecurrencyType().equals(SchedulerSetupRecurrenceType.MONTHLY) &&
                    !this.data.getRecurrencyType().equals(SchedulerSetupRecurrenceType.YEARLY)) {
                this.data.setExecutionTime(null);
            }

            if (!this.data.getRecurrencyType().equals(SchedulerSetupRecurrenceType.MINUTELY)
                    && !this.data.getRecurrencyType().equals(SchedulerSetupRecurrenceType.HOURLY)) {
                this.data.setStartHour(null);
                this.data.setEndHour(null);
            }

            if (this.data.getRecurrencyType().equals(SchedulerSetupRecurrenceType.FAST)
                    || this.data.getRecurrencyType().equals(SchedulerSetupRecurrenceType.CRON_NATIVE)) {
                this.data.setIntervalMinutes(null);
                this.data.setIntervalOffset(null);
            }
        }
    }
}

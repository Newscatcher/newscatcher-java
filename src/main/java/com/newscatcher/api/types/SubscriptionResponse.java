/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.newscatcher.api.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.newscatcher.api.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = SubscriptionResponse.Builder.class)
public final class SubscriptionResponse {
    private final boolean active;

    private final Optional<Integer> callsPerSeconds;

    private final String planName;

    private final Optional<Integer> usageAssignedCalls;

    private final Optional<Integer> usageRemainingCalls;

    private final Optional<Integer> historicalDays;

    private final Map<String, Object> additionalProperties;

    private SubscriptionResponse(
            boolean active,
            Optional<Integer> callsPerSeconds,
            String planName,
            Optional<Integer> usageAssignedCalls,
            Optional<Integer> usageRemainingCalls,
            Optional<Integer> historicalDays,
            Map<String, Object> additionalProperties) {
        this.active = active;
        this.callsPerSeconds = callsPerSeconds;
        this.planName = planName;
        this.usageAssignedCalls = usageAssignedCalls;
        this.usageRemainingCalls = usageRemainingCalls;
        this.historicalDays = historicalDays;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("active")
    public boolean getActive() {
        return active;
    }

    @JsonProperty("calls_per_seconds")
    public Optional<Integer> getCallsPerSeconds() {
        return callsPerSeconds;
    }

    @JsonProperty("plan_name")
    public String getPlanName() {
        return planName;
    }

    @JsonProperty("usage_assigned_calls")
    public Optional<Integer> getUsageAssignedCalls() {
        return usageAssignedCalls;
    }

    @JsonProperty("usage_remaining_calls")
    public Optional<Integer> getUsageRemainingCalls() {
        return usageRemainingCalls;
    }

    @JsonProperty("historical_days")
    public Optional<Integer> getHistoricalDays() {
        return historicalDays;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SubscriptionResponse && equalTo((SubscriptionResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(SubscriptionResponse other) {
        return active == other.active
                && callsPerSeconds.equals(other.callsPerSeconds)
                && planName.equals(other.planName)
                && usageAssignedCalls.equals(other.usageAssignedCalls)
                && usageRemainingCalls.equals(other.usageRemainingCalls)
                && historicalDays.equals(other.historicalDays);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.active,
                this.callsPerSeconds,
                this.planName,
                this.usageAssignedCalls,
                this.usageRemainingCalls,
                this.historicalDays);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ActiveStage builder() {
        return new Builder();
    }

    public interface ActiveStage {
        PlanNameStage active(boolean active);

        Builder from(SubscriptionResponse other);
    }

    public interface PlanNameStage {
        _FinalStage planName(@NotNull String planName);
    }

    public interface _FinalStage {
        SubscriptionResponse build();

        _FinalStage callsPerSeconds(Optional<Integer> callsPerSeconds);

        _FinalStage callsPerSeconds(Integer callsPerSeconds);

        _FinalStage usageAssignedCalls(Optional<Integer> usageAssignedCalls);

        _FinalStage usageAssignedCalls(Integer usageAssignedCalls);

        _FinalStage usageRemainingCalls(Optional<Integer> usageRemainingCalls);

        _FinalStage usageRemainingCalls(Integer usageRemainingCalls);

        _FinalStage historicalDays(Optional<Integer> historicalDays);

        _FinalStage historicalDays(Integer historicalDays);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ActiveStage, PlanNameStage, _FinalStage {
        private boolean active;

        private String planName;

        private Optional<Integer> historicalDays = Optional.empty();

        private Optional<Integer> usageRemainingCalls = Optional.empty();

        private Optional<Integer> usageAssignedCalls = Optional.empty();

        private Optional<Integer> callsPerSeconds = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(SubscriptionResponse other) {
            active(other.getActive());
            callsPerSeconds(other.getCallsPerSeconds());
            planName(other.getPlanName());
            usageAssignedCalls(other.getUsageAssignedCalls());
            usageRemainingCalls(other.getUsageRemainingCalls());
            historicalDays(other.getHistoricalDays());
            return this;
        }

        @java.lang.Override
        @JsonSetter("active")
        public PlanNameStage active(boolean active) {
            this.active = active;
            return this;
        }

        @java.lang.Override
        @JsonSetter("plan_name")
        public _FinalStage planName(@NotNull String planName) {
            this.planName = Objects.requireNonNull(planName, "planName must not be null");
            return this;
        }

        @java.lang.Override
        public _FinalStage historicalDays(Integer historicalDays) {
            this.historicalDays = Optional.ofNullable(historicalDays);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "historical_days", nulls = Nulls.SKIP)
        public _FinalStage historicalDays(Optional<Integer> historicalDays) {
            this.historicalDays = historicalDays;
            return this;
        }

        @java.lang.Override
        public _FinalStage usageRemainingCalls(Integer usageRemainingCalls) {
            this.usageRemainingCalls = Optional.ofNullable(usageRemainingCalls);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "usage_remaining_calls", nulls = Nulls.SKIP)
        public _FinalStage usageRemainingCalls(Optional<Integer> usageRemainingCalls) {
            this.usageRemainingCalls = usageRemainingCalls;
            return this;
        }

        @java.lang.Override
        public _FinalStage usageAssignedCalls(Integer usageAssignedCalls) {
            this.usageAssignedCalls = Optional.ofNullable(usageAssignedCalls);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "usage_assigned_calls", nulls = Nulls.SKIP)
        public _FinalStage usageAssignedCalls(Optional<Integer> usageAssignedCalls) {
            this.usageAssignedCalls = usageAssignedCalls;
            return this;
        }

        @java.lang.Override
        public _FinalStage callsPerSeconds(Integer callsPerSeconds) {
            this.callsPerSeconds = Optional.ofNullable(callsPerSeconds);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "calls_per_seconds", nulls = Nulls.SKIP)
        public _FinalStage callsPerSeconds(Optional<Integer> callsPerSeconds) {
            this.callsPerSeconds = callsPerSeconds;
            return this;
        }

        @java.lang.Override
        public SubscriptionResponse build() {
            return new SubscriptionResponse(
                    active,
                    callsPerSeconds,
                    planName,
                    usageAssignedCalls,
                    usageRemainingCalls,
                    historicalDays,
                    additionalProperties);
        }
    }
}